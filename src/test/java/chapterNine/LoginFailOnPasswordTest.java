package chapterNine;

import general.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginFailOnPasswordTest extends TestShopScenario {

    @Test
    public void logInFailWrongPassWord() {
        String signInEmail = "gerrit@elsenaar.com";
        String signInPassword = "mn";
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm(signInEmail, signInPassword);

        System.out.println(loginPage.loginFailOnPassword());
        Assertions.assertThat(loginPage.loginFailOnPassword())
                .as("Fout password")
                .isTrue();
    }

}
