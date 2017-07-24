package chapterNine;

import general.TestShopScenario;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestShopScenario {

    @Test
    public void logIn() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm("gerrit@elsenaar.com", "1qazxsw2");
    }
}
