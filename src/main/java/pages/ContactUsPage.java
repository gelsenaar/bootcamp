package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class ContactUsPage {

    private WebDriver driver;

    @FindBy(css = "input#email")
    private WebElement emailTextField;
    @FindBy(css = "input#id_order")
    private WebElement orderReference;
    @FindBy(css = "textarea#message")
    private WebElement messageText;
    @FindBy(css = "button#submitMessage")
    private WebElement submitButton;
    @FindBy(xpath = ".//*[@class='alert alert-success']")
    private WebElement successMessage;
    @FindBy(xpath = ".//*[@class='alert alert-danger']")
    private WebElement failMessage;

    private String wrongMailAddress = "Invalid email address.";
    private String wrongMessageContent = "The message cannot be blank.";
    private String receivedMessage = "";

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        //This call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    public void fillInContactForm(String email, String order, String message, String heading) {
        Select subjectHeading = new Select(driver.findElement(By.cssSelector("select#id_contact")));
        subjectHeading.selectByVisibleText(heading);
        emailTextField.sendKeys(email);
        orderReference.sendKeys(order);
        messageText.sendKeys(message);
        submitButton.click();
    }

    public boolean checkSuccess() {
        boolean returnValue = true;
        List success = new ArrayList();
        success.add(successMessage);
        List fail = new ArrayList();
        fail.add(successMessage);

        if (success.size() == 1) {
            returnValue = true;
        }
        if (fail.size() == 1) {
            returnValue = false;
            receivedMessage = readErrorMessage();
            if (receivedMessage == wrongMailAddress) {
                emailTextField.clear();
                emailTextField.sendKeys("nope@correct.com");
                submitButton.click();
            }
            if (receivedMessage == wrongMessageContent) {
                messageText.sendKeys("Eerst leeg, nu gevuld");
                submitButton.click();
            }
        }
        return returnValue;
    }

    public void correctFields() {

    }

    private String readErrorMessage() {
        String reportMessage = "";
        if (failMessage.getText().contains(wrongMailAddress)) {
            reportMessage = wrongMailAddress;
        }
        if (failMessage.getText().contains(wrongMessageContent)) {
            reportMessage = wrongMessageContent;
        }
        return reportMessage;
    }
}
