
import org.junit.Test;


import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class InventoryTests extends BaseTest {


    @Test
    public void visibilityOfProductCards(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.allProductCardsAreVisible();

    }

    @Test
    public void checkProductAdded() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.allProductCardsAreVisible();
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        SideBar sideBar= new SideBar(driver);
        sideBar.openSideBar();
        sleep(1000);
        sideBar.clickOnResetApp();
        sideBar.closeSideBar();
        inventoryPage.clickOnBackpackAddToCart();
        sleep(1000);
    }

    @Test
    public void checkLogoutLink(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.allProductCardsAreVisible();
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        SideBar sideBar= new SideBar(driver);
        sideBar.openSideBar();
        sideBar.clickOnLogoutLink();
        loginPage.loginPageIsOpen();
    }

    @Test
    public void checkFilterProductsByNameAtoZ(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnSortNameAtoZ();
        assertEquals("Sauce Labs Backpack", inventoryPage.firstItemName.getText());
    }

    @Test
    public void checkFilterProductsByNameZtoA(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnSortNameZtoA();
        assertEquals("Test.allTheThings() T-Shirt (Red)",  inventoryPage.firstItemName.getText());
    }
    @Test
    public void checkFilterProductsByPriceLowToHigh(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnSortPriceLowToHigh();
        assertEquals("$7.99",  inventoryPage.firstItemPrice.getText());
    }
    @Test
    public void checkFilterProductsByPriceHighToLow(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnSortPriceHighToLow();
        assertEquals("$49.99",  inventoryPage.firstItemPrice.getText());
    }



}
