package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private WebDriver driver;
    @FindBy(xpath = "//*[@id='center_column']/div/div[2]/ul/li[2]/a/span")
    private WebElement myWishlistButton;


    //*[@id="center_column"]/div/div[2]/ul/li[2]/a/span

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);

    }

    public void clickMyWishList() {
        myWishlistButton.click();
    }
}
