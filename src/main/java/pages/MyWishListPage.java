package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyWishListPage {
    private WebDriver driver;

    //Needed to add a wish
    @FindBy(xpath = "//*[@id='name']")
    private WebElement wishName;

    @FindBy(xpath = "//*[@id='submitWishlist']/span")
    private WebElement saveButton;

    @FindBy(xpath = ".//*[@id='block-history']")
    private WebElement myWishList;

    public MyWishListPage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    public void addWish(String wishNameAdd) {

        wishName.sendKeys(wishNameAdd);
        saveButton.click();
    }

    public void deleteWish(String wishNameToDelete) {
        driver.findElement(By.xpath(".//a[contains(text(), '" + wishNameToDelete + "')]" +
                "/ancestor::tr/td[@class='wishlist_delete']/a")).click();
        driver.switchTo().alert().accept();
    }

    public boolean controleer(String wishToCheck) {
        boolean zichtbaar = false;
        zichtbaar = driver.findElement(By.xpath(".//a[contains(text(), 'First add a wish')]")).isDisplayed();
        return zichtbaar;
    }

    public boolean checkExistence(String wishToCheck) {

        //To locate table.
        //To locate rows of table.
        List<WebElement> rows_table = myWishList.findElements(By.tagName("tr"));
        //To calculate no of rows In table.
        int rows_count = rows_table.size();
        boolean wishExists = false;

        //Loop will execute till the last row of table.
        for (int row = 0; row < rows_count; row++) {
            //To locate columns(cells) of that specific row.
            List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            //To calculate no of columns(cells) In that specific row.
            int columns_count = Columns_row.size();
            //System.out.println("Number of cells In Row " + row + " are " + columns_count);

            //Loop will execute till the last cell of that specific row.
            for (int column = 0; column < columns_count; column++) {
                //To retrieve text from that specific cell.
                String cellText = Columns_row.get(column).getText();
                //System.out.println("Cell Value Of row number " + row + " and column number " + column + " Is " + cellText);
                if (cellText.equals(wishToCheck))
                    wishExists = true;
            }
        }
        return wishExists;
    }
}