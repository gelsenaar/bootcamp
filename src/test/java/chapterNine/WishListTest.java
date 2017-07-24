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

    @Test
    public void addToWishList() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MyWishListPage myWishListPage = new MyWishListPage(driver);
        String wishToAdd = "First add a wish";

        homePage.clickLogIn();
        loginPage.loginForm(signInEmail, signInPassword);
        myAccountPage.clickMyWishList();
        if (myWishListPage.checkExistence(wishToAdd)) {  // == true
            myWishListPage.addWish(wishToAdd);
            Assertions.assertThat(myWishListPage.checkExistence(wishToAdd))
                    .as("Wish " + wishToAdd + "should have been added")
                    .isFalse();
        }
        else {
            System.out.println("Hij bestaat al");
        }
    }

    @Test
    public void deleteFromWishList() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MyWishListPage myWishListPage = new MyWishListPage(driver);
        String wishToDelete = "First add a wish";

        homePage.clickLogIn();
        loginPage.loginForm(signInEmail, signInPassword);
        myAccountPage.clickMyWishList();
        if (!myWishListPage.checkExistence(wishToDelete)) {  // == false
            myWishListPage.deleteWish(wishToDelete);
            Assertions.assertThat(myWishListPage.checkExistence(wishToDelete))
                    .as("Hij is weg")
                    .isFalse();
        }
        else {
            System.out.println("Niet te vinden");
        }
    }
}


