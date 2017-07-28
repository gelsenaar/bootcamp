package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyWishListPage {
    private WebDriver driver;

    String nameColumn = "Name";
    String deleteColumn = "Delete";
    int nameColumnNumber;
    int deleteColumnNumber;

    //Needed to add a wish
    @FindBy(xpath = "//*[@id='name']")
    private WebElement wishName;
    @FindBy(xpath = "//*[@id='submitWishlist']/span")
    private WebElement saveButton;

    //The wishList
    @FindBy(xpath = ".//*[@id='block-history']")
    private WebElement mijnWensenLijst;

    public MyWishListPage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    public void addWish(String wishToAdd) {
        wishName.sendKeys(wishToAdd);
        saveButton.click();
    }

    public boolean checkWishExists(String wishToCheck) {
        List<WebElement> myWishTable = driver.findElements(By.xpath(".//a[contains(text(), '" + wishToCheck + "')]"));
        System.out.println(!myWishTable.isEmpty());
        return !myWishTable.isEmpty();
    }

    public void deleteWishOne(String wishToDelete) {
        driver.findElement(By.xpath(".//a[contains(text(), '" + wishToDelete + "')]" +
                "/ancestor::tr/td[@class='wishlist_delete']/a")).click();
        driver.switchTo().alert().accept();
    }

    public void deleteWishTwo(String theWish) {
        //WebDriverWait waitForElement = new WebDriverWait(driver, 10);
        List<WebElement> headerTable = mijnWensenLijst.findElements(By.cssSelector("thead"));
        int rowsInHeader = headerTable.size();
        for (int row = 0; row < rowsInHeader; row++) {
            //To locate columns(cells) of that specific row.
            List<WebElement> columnsInHeader = headerTable.get(row).findElements(By.cssSelector("th"));
            int columnsInHeaderCount = columnsInHeader.size();
            //Loop will execute till the last cell of that specific row.
            for (int column = 0; column < columnsInHeaderCount; column++) {
                // To retrieve text from that specific cell.
                String cellText = columnsInHeader.get(column).getText();
                if (cellText.equals(nameColumn)) {
                    nameColumnNumber = column;
                } else if (cellText.equals(deleteColumn)) {
                    deleteColumnNumber = column;
                }
            }
        }
        //To locate rows of table.
        List<WebElement> detailsTable = mijnWensenLijst.findElements(By.tagName("tr"));
        //To calculate no of rows In table.
        int rowsInDetails = detailsTable.size();
        //Loop will execute till the last row of table.
        for (int row = 0; row < rowsInDetails; row++) {
            //To locate columns(cells) of that specific row.
            List<WebElement> columnsInTable = detailsTable.get(row).findElements(By.tagName("td"));
            //To calculate no of columns (cells). In that specific row.
            int columnsInDetailsCount = columnsInTable.size();
            //Loop will execute till the last cell of that specific row.
            for (int column = 0; column < columnsInDetailsCount; column++) {
                // To retrieve text from that specific cell.
                String cellText = columnsInTable.get(column).getText();
                if (column == nameColumnNumber) {
                    if (cellText.equals(theWish)) {
                        int rowToDelete = row;
                        deleteColumnNumber = deleteColumnNumber+1;
                        nameColumnNumber = nameColumnNumber+1;
                        mijnWensenLijst.findElement(By.xpath("//tr[" + rowToDelete + "]/td[" + deleteColumnNumber + "]/a/i")).click();
                        driver.switchTo().alert().accept();
                        break;
                    }
                }
            }
        }
    }
}