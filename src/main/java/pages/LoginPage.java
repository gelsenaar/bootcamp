package pages;

import org.openqa.selenium.By;
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
    @FindBy(xpath = ".//*[@id='login_form']/div/div[@class='form-group form-error']/input[@class='is_required validate account_input form-control']")
    private WebElement wrongMailAddress;
    @FindBy(xpath = ".//*[@class='alert alert-danger']")
    private WebElement failMessage;

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

    public String loginSuccess() {
        return driver.findElement(By.className("page-heading")).getText();

    }

    public boolean loginFailOnEmail() {
        return wrongMailAddress.isDisplayed();
    }

    public boolean loginFailOnPassword() {
        return failMessage.isDisplayed();
    }
}
