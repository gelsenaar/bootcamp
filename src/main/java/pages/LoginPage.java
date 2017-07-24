package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailField;
    @FindBy(xpath = "//*[@id='passwd']")
    private WebElement passWordField;
    @FindBy(xpath = "//*[@id='SubmitLogin']/span")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);

    }

    public void loginForm(String email, String passWord) {

        emailField.sendKeys(email);
        passWordField.sendKeys(passWord);
        submitButton.click();
    }

    public void loginSuccess() {

    }
}
