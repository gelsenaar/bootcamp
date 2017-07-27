package chapterNine;

import general.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.*;

public class WishListTest extends TestShopScenario {
    private String signInEmail = "gerrit@elsenaar.com";
    private String signInPassword = "1qazxsw2";
    //private String wishUnderConstruction = "This is my personal wish";
    private String wishUnderConstruction = "Feel the pain";

    @Test
    public void addToWishList() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MyWishListPage myWishListPage = new MyWishListPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm(signInEmail, signInPassword);
        myAccountPage.clickMyWishList();
        if (!myWishListPage.checkWishExists(wishUnderConstruction)) {
            myWishListPage.addWish(wishUnderConstruction);
            Assertions.assertThat(myWishListPage.checkWishExists(wishUnderConstruction))
                    .as("The wish '" + wishUnderConstruction + "' should have been added")
                    .isTrue();
        } else {
            System.out.println("The wish '" + wishUnderConstruction + "' is already in the list");
        }
    }

    @Test
    public void ffChecken() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MyWishListPage myWishListPage = new MyWishListPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm(signInEmail, signInPassword);
        myAccountPage.clickMyWishList();
        System.out.println(myWishListPage.checkWishExists(wishUnderConstruction));
        }

    @Test
    public void deleteFromWishListOne() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MyWishListPage myWishListPage = new MyWishListPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm(signInEmail, signInPassword);
        myAccountPage.clickMyWishList();
        if (myWishListPage.checkWishExists(wishUnderConstruction)) {
            myWishListPage.deleteWishOne(wishUnderConstruction);
            System.out.println("Wish is deleted");
            Thread.sleep(3000);
            Assertions.assertThat(myWishListPage.checkWishExists(wishUnderConstruction))
                    .as("The wish '" + wishUnderConstruction + "' should have been deleted")
                    .isFalse();
        } else {
            System.out.println("The wish '" + wishUnderConstruction + "' is not in the list");
        }
    }

    @Test
    public void deleteFromWishListTwo() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MyWishListPage myWishListPage = new MyWishListPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm(signInEmail, signInPassword);
        myAccountPage.clickMyWishList();
        if (myWishListPage.checkWishExists(wishUnderConstruction)) {
            myWishListPage.deleteWishTwo(wishUnderConstruction);
            System.out.println("Wish is deleted");
            Thread.sleep(3000);
            Assertions.assertThat(myWishListPage.checkWishExists(wishUnderConstruction))
                    .as("The wish '" + wishUnderConstruction + "' should have been deleted")
                    .isFalse();
        } else {
            System.out.println("The wish '" + wishUnderConstruction + "' is not in the list");
        }
    }
}


