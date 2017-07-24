package chapterNine;

import general.TestShopScenario;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyWishListPage;

public class WishListTest extends TestShopScenario {

    @Test
    public void addToWishList() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MyWishListPage myWishListPage = new MyWishListPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm("gerrit@elsenaar.com", "1qazxsw2");
        myAccountPage.clickMyWishList();
        if (!myWishListPage.checkExistence("First add a wish")) {
            myWishListPage.addWish("First add a wish");
        }
        else {
            System.out.println("Hij bestaat al");
        }
    }

    @Test
    public void checkenList() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MyWishListPage myWishListPage = new MyWishListPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm("gerrit@elsenaar.com", "1qazxsw2");
        myAccountPage.clickMyWishList();
        //myWishListPage.addWish("First add a wish");
        if (myWishListPage.controleer("First add a wish")) {
            System.out.println("Hij bestaat");
        }
        else {
            System.out.println("Hij bestaat NIET");
        }
    }

    @Test
    public void deleteFromWishList() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MyWishListPage myWishListPage = new MyWishListPage(driver);

        homePage.clickLogIn();
        loginPage.loginForm("gerrit@elsenaar.com", "1qazxsw2");
        myAccountPage.clickMyWishList();
        if (myWishListPage.checkExistence("First add a wish")) {
            myWishListPage.deleteWish("First add a wish");
        }
        else {
            System.out.println("Niet te vinden");
        }
    }
}


