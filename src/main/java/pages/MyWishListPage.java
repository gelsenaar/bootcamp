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

    public boolean checkExistence(String wishToCheck) {
        List<WebElement> myWishTable = driver.findElements(By.xpath(".//a[contains(text(), '" + wishToCheck + "')]"));
        return myWishTable.isEmpty();
    }

}