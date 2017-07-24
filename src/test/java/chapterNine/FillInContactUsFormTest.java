package chapterNine;

import general.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class FillInContactUsFormTest extends TestShopScenario{

    @Test
    public void fillInContactForm() {
        //driver.findElement(By.cssSelector("li#header_link_contact > a")).click();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickContactUsLink();
        contactUsPage.fillInContactForm("name@domain.com","ABC123", "This order sucks");

        Assertions.assertThat(contactUsPage.checkSuccess()).isTrue();
    }
}
