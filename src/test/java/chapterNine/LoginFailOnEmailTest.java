package chapterNine;

import general.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginFailOnEmailTest extends TestShopScenario {

    @Test
    public void logInFailWrongEmail() {
        String signInEmail = "gerrit";
        String signInPassword = "1qazxsw2";
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm(signInEmail, signInPassword);

        System.out.println(loginPage.loginFailOnEmail());
        Assertions.assertThat(loginPage.loginFailOnEmail())
                .as("Fout mailadres")
                .isTrue();
    }

}
