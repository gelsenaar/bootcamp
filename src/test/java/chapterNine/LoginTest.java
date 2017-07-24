package chapterNine;

import general.TestShopScenario;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestShopScenario {
    private String signInEmail = "gerrit@elsenaar.com";
    private String signInPassword = "1qazxsw2";

    @Test
    public void logIn() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm(signInEmail, signInPassword);
    }
}
