package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(css = "li#header_link_contact > a")
    private WebElement contactUsLink;
    @FindBy(className = "login")
    private WebElement signInLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    public void clickContactUsLink() {
        contactUsLink.click();
    }

    public void clickLogIn() {
        signInLink.click();
    }

}
