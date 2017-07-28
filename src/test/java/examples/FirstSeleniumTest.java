package examples;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by Gerrit Elsenaar on 19-7-2017.
 */
public class FirstSeleniumTest {

    @Test
    public void logInSuccesFull() {
        String mailAddress = "tester@test.com";
        String passWord = "1qazxsw2";
        String textToValidate;
        String textContent = "personal";

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();

        //SoftAssertions softly = new SoftAssertions();

        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email")).sendKeys(mailAddress);
        driver.findElement(By.id("passwd")).sendKeys(passWord);

        driver.findElement(By.id("SubmitLogin")).click();


        textToValidate = driver.findElement(By.className("info-account")).getText();
        Assertions.assertThat(textToValidate).as("Een header").contains(textContent);

        driver.quit();
    }
}
