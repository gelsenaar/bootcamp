package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


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
    @FindBy(xpath = "//*[@id='center_column']/p")
    private WebElement successMessage;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        //This call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    public void fillInContactForm(String email, String order, String message) {
        Select subjectHeading = new Select(driver.findElement(By.cssSelector("select#id_contact")));
        subjectHeading.selectByVisibleText("Customer service");
        emailTextField.sendKeys(email);
        orderReference.sendKeys(order);
        messageText.sendKeys(message);
        submitButton.click();
    }

    public boolean checkSuccess() {
        return successMessage.isDisplayed();
        //Assertions.assertThat(driver.findElement(By.xpath("//*[@id='center_column']/p")).isDisplayed()).isTrue();
    }
}
