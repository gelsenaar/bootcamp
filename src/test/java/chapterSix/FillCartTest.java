package chapterSix;

import general.TestShopScenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by Gerrit Elsenaar on 20-7-2017.
 */
public class FillCartTest extends TestShopScenario {

    @Test
    public void fillCart() {

        String cartValueActual;
        String cartValueExpected = "Cart (empty)";

        cartValueActual = driver.findElement(By.className("shopping_cart")).getText();
        driver.findElement(By.className("shopping_cart")).isDisplayed();
        System.out.println(cartValueActual);

        driver.findElement(By.xpath("//a[@class='iPod Nano']")).click();
      }
}
