package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;

    @FindBy(className = "shopping_cart")
    private WebElement shoppingCart;
    @FindBy(className = "ajax_cart_no_product")
    private WebElement emptyCart;
    @FindBy(xpath = "//a[@title='More about ipod']")
    private WebElement ipodTag;
    @FindBy(xpath = "//*[@id='add_to_cart']/button")
    private WebElement addToCartButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        //This call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    public boolean checkCartIsEmpty(String cartStatus) {
        shoppingCart.isDisplayed();
        return emptyCart.getText().trim().equals(cartStatus);

    }

    public void fillCart(String productToBuy) {
        WebDriverWait waitForElement = new WebDriverWait(driver, 10);

        ipodTag.click();
        driver.findElement(By.xpath(".//a[contains(text(), '" + productToBuy + "')]")).click();
        addToCartButton.click();
        waitForElement.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[@title='Continue shopping']")));
        driver.findElement(By.xpath(".//span[@title='Continue shopping']")).click();

    }

    public void emptyCart(String productToAddAndDelete) {
        WebDriverWait waitForElement = new WebDriverWait(driver, 10);

        ipodTag.click();
        driver.findElement(By.xpath(".//a[contains(text(), '" + productToAddAndDelete + "')]")).click();
        addToCartButton.click();
        waitForElement.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[@title='Continue shopping']")));
        driver.findElement(By.xpath(".//span[@title='Continue shopping']")).click();

        //waitForElement.until(ExpectedConditions.elementToBeClickable(By.xpath("//[@class='shopping_cart']/a")));
        System.out.println(driver.findElement(By.xpath("//div[@class='shopping_cart']/a[@title='View my shopping cart']")).getText());
        driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
        //div class="shopping_cart"
        //.//*[@class='shopping_cart']/a
    }

    public void controleer() {
//        System.out.println(driver.findElement(By.xpath(".//span[@class='ajax_cart_product_txt']")).getText());
//        driver.findElement(By.xpath(".//span[@class='ajax_cart_product_txt']")).click();
        shoppingCart.click();

    }
}
