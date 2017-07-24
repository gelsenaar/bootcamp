package chapterSix;

import general.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

/**
 * Created by Gerrit Elsenaar on 20-7-2017.
 */
public class FillCartTest extends TestShopScenario {

//    @Test
    public void fillCart() throws InterruptedException {

        String cartValueActual;
        String cartEmpty = "Cart (empty)";
        String cartFilled = "Cart 1 Product";

        cartValueActual = driver.findElement(By.className("shopping_cart")).getText();
        driver.findElement(By.className("shopping_cart")).isDisplayed();
        Assertions.assertThat(driver.findElement(By.cssSelector(".ajax_cart_no_product"))
                .isDisplayed())
                .as("Empty cart")
                .isTrue();

        driver.findElement(By.cssSelector("a[title='More about ipod']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'iPod shuffle')]")).click();

        driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();

        Thread.sleep(500);

        driver.findElement(By.cssSelector("span[title='Continue shopping']")).click();
        cartValueActual = driver.findElement(By.className("shopping_cart")).getText();
        Assertions.assertThat(driver.findElement(By.cssSelector(".ajax_cart_no_product"))
                .isDisplayed())
                .as("Filled cart")
                .isFalse();
     }
}
