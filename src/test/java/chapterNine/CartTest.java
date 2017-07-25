package chapterNine;

import general.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.CartPage;

/**
 * Created by Gerrit Elsenaar on 20-7-2017.
 */
public class CartTest extends TestShopScenario {

    @Test
    public void fillCart() throws InterruptedException {
        CartPage cartPage = new CartPage(driver);
        String cartEmpty = "(empty)";
        String cartFilled = "Cart 1 Product";
        String productToBuy = "iPod shuffle";

        Assertions.assertThat(cartPage.checkCartIsEmpty(cartEmpty)).isTrue();

        cartPage.fillCart(productToBuy);

        Assertions.assertThat(cartPage.checkCartIsEmpty(cartFilled)).isFalse();
     }

     @Test
    public void emptyCart() {
         CartPage cartPage = new CartPage(driver);
         String cartEmpty = "(empty)";
         String cartFilled = "Cart 1 Product";
         String productToBuy = "iPod shuffle";

         cartPage.emptyCart(productToBuy);

     }

     @Test
    public  void ffchecken() {
         CartPage cartPage = new CartPage(driver);
         cartPage.controleer();
     }
}
