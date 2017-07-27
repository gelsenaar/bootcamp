package chapterNine;

import general.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class FillInContactUsFormTest extends TestShopScenario {

    String subject1 = "Customer Service";
    String email1 = "heavylifter@feelthepain.com";
    String order1 = "4321234";
    String message1 = "Waar zijn m'n eiwitten";

    String subject2 = "Customer Service";
    String email2 = "hipster@tester.com";
    String order2 = "9876";
    String message2 = "Mn MAcBook is te oud :(";

    String subject3 = "Customer Service";
    String email3 = "feelfit@nopainnogain.com";
    String order3 = "12345";
    String message3 = "Busted my iphone will lifting bro!";

    String subject4 = "Customer Service";
    String email4 = "test@guru.com";
    String order4 = "666";
    String message4 = "Still waiting for my Tmap book!";

    String subject5 = "Customer Service";
    String email5 = "cross@fit.com";
    String order5 = "7777";
    String message5 = "Iphone 8, when?";

    @Test
    public void fillInContactFormSuccess() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickContactLink();
        contactUsPage.fillInContactForm("name@domain.com", "ABC123", "This order sucks", "Customer service");

        Assertions.assertThat(contactUsPage.checkSuccess()).isTrue();
    }

    @Test
    public void fillInContactFormFail() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickContactLink();
        contactUsPage.fillInContactForm("nope", "4321234", "Help", "Customer service");

        Assertions.assertThat(contactUsPage.checkSuccess()).isFalse();
    }

    @Test
    public void fillInContactFormWrongEmail() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickContactLink();
        contactUsPage.fillInContactForm("nope", "4321234", "Help", "Customer service");

        contactUsPage.checkSuccess();
    }

    @Test
    public void fillInContactFormEmptyMessage() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickContactLink();
        contactUsPage.fillInContactForm("nope@correct.com", "4321234", "", "Customer service");

        contactUsPage.checkSuccess();
    }
}
