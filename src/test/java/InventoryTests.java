
import org.junit.Test;

import static java.lang.Thread.sleep;
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



}
