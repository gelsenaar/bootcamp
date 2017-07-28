package chapterNine;

import general.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginSuccessTest extends TestShopScenario {

    @Test
    public void logInSuccess() {
        String signInEmail = "gerrit@elsenaar.com";
        String signInPassword = "1qazxsw2";
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm(signInEmail, signInPassword);

        Assertions.assertThat(loginPage.loginSuccess())
                .as("The header value differs:")
                .contains("MY ACCOUNT");
    }
}
