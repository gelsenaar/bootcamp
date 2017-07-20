package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by Gerrit Elsenaar on 20-7-2017.
 */
public class SignOutTest {

    WebDriver driver;

    @Test
    public void logInAndLogoutTest() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();

        logInTest();
        logOutTest();

    }


    public void logInTest() {
        String mailAddress = "tester@test.com";
        String passWord = "1qazxsw2";
        String textToValidate;
        String textIngelogd = "personal";


        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();

        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email")).sendKeys(mailAddress);
        driver.findElement(By.id("passwd")).sendKeys(passWord);

        driver.findElement(By.id("SubmitLogin")).click();

        textToValidate = driver.findElement(By.className("info-account")).getText();
        Assertions.assertThat(textToValidate).as("Een header").contains(textIngelogd);

    }

    public void logOutTest() {

        String textToValidate;
        String textUitgelogd = "Sign in";

        driver.findElement(By.className("logout")).click();
        textToValidate = driver.findElement(By.className("login")).getText();
        Assertions.assertThat(textToValidate).as("Uitgelogd").contains(textUitgelogd);
        driver.quit();
    }

    /**
     * Created by Gerrit Elsenaar on 20-7-2017.
     * Bovenste drie methodes werken: 1 initialiseert, 1 voor inloggen, q voor uitloggen
     * Onderste doet alle 3 in 1     *
     */
    @Test
    public void logAndLogoutTest() {
        String mailAddress = "tester@test.com";
        String passWord = "1qazxsw2";
        String textToValidate;
        String textIngelogd = "personal";
        String textUitgelogd = "Sign in";

        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();

        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email")).sendKeys(mailAddress);
        driver.findElement(By.id("passwd")).sendKeys(passWord);

        driver.findElement(By.id("SubmitLogin")).click();

        textToValidate = driver.findElement(By.className("info-account")).getText();
        Assertions.assertThat(textToValidate).as("Een header").contains(textIngelogd);

        driver.findElement(By.className("logout")).click();
        textToValidate = driver.findElement(By.className("login")).getText();
        Assertions.assertThat(textToValidate).as("Uitgelogd").contains(textUitgelogd);
        driver.quit();
    }
}
