import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest extends BaseTest{

    @Test
    public void checkoutTotalItem(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBikeLichtAddToCart();
        inventoryPage.clickOnCartIcon();

        CartPage cartPage = new CartPage(driver);
        double totalFromCart = cartPage.getTotalPrices();
        cartPage.clickOnCheckoutButton();

        CheckoutStepOne checkoutStepOne = new CheckoutStepOne(driver);
        checkoutStepOne.inputAllFields();
        checkoutStepOne.clickOnContinueButton();

        CheckoutStepTwo checkoutStepTwo = new CheckoutStepTwo(driver);
        assertEquals(totalFromCart, checkoutStepTwo.totalPriceFromStepTwo(), 0);
        System.out.println(checkoutStepTwo.totalPriceAnTheEnd());
        System.out.println(checkoutStepTwo.totalWithTaxSum());
        assertEquals(checkoutStepTwo.totalPriceAnTheEnd(), checkoutStepTwo.totalWithTaxSum(), 0);



}
}
