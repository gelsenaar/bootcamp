package chapterNine;

import general.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyWishListPage;

public class WishListTest extends TestShopScenario {
    private String signInEmail = "gerrit@elsenaar.com";
    private String signInPassword = "1qazxsw2";
    private String wishUnderConstruction = "This is my personal wish";

    @Test
    public void addToWishList() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MyWishListPage myWishListPage = new MyWishListPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm(signInEmail, signInPassword);
        myAccountPage.clickMyWishList();
        if (myWishListPage.checkExistence(wishUnderConstruction)) {
            myWishListPage.addWish(wishUnderConstruction);
            Assertions.assertThat(myWishListPage.checkExistence(wishUnderConstruction))
                    .as("The wish '" + wishUnderConstruction + "' should have been added")
                    .isFalse();
        }
        else {
            System.out.println("The wish '" + wishUnderConstruction + "' is already in the list");
        }
    }

    @Test
    public void deleteFromWishList() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MyWishListPage myWishListPage = new MyWishListPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm(signInEmail, signInPassword);
        myAccountPage.clickMyWishList();
        if (!myWishListPage.checkExistence(wishUnderConstruction)) {
            myWishListPage.deleteWish(wishUnderConstruction);
            Assertions.assertThat(myWishListPage.checkExistence(wishUnderConstruction))
                    .as("The wish '" + wishUnderConstruction + "' should have been deleted")
                    .isFalse();
        }
        else {
            System.out.println("The wish '" + wishUnderConstruction + "' is not in the list");
        }
    }
}


