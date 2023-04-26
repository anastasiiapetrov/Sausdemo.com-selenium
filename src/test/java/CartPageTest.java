import org.junit.Test;

import static org.junit.Assert.*;

public class CartPageTest extends BaseTest{

    @Test
    public void successAdding1Item(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        String costFromInventoryPage = inventoryPage.checkPriceOnInventoryPage();
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.firstItemIsDisplayed());
        assertEquals(1, cartPage.getItemsQuantity());
        assertEquals(costFromInventoryPage, cartPage.priceOnCartPage());





    }


    public void adding3Items(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnTShirtAddToCart();
        inventoryPage.clickOnBikeLichtAddToCart();

        inventoryPage.clickOnCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertEquals(3, cartPage.getItemsQuantity());
        assertTrue(cartPage.allItemsAreDisplayed());
    }


    public void emptyCart() {
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnCartIcon();

        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.cartIsEmpty());

    }



}