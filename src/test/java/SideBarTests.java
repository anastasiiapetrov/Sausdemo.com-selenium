import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SideBarTests extends BaseTest{

    @Test
    public void linksAreDisplayed (){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        SideBar sideBar= new SideBar(driver);
        sideBar.openSideBar();
        assertTrue(sideBar.allItemLinkIDisplayed());
        assertTrue(sideBar.aboutLinkIDisplayed());
        assertTrue(sideBar.crossSideBarButtonIDisplayed());
        assertTrue(sideBar.resetLinkIDisplayed());
        assertTrue(sideBar.logOutLinkIDisplayed());
    }


        public void closeSideBar() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            User validUser = new User(validUserName, validPassword);
            loginPage.successLogin(validUser);
            InventoryPage inventoryPage = new InventoryPage((driver));
            assertTrue(inventoryPage.inventoryContainerIsDisplayed());

            SideBar sideBar= new SideBar(driver);
            sideBar.openSideBar();

            sideBar.closeSideBar();
            sideBar.sideBarHasHidden();
        sleep(1000);
        assertFalse(sideBar.allItemLinkIDisplayed());
        assertFalse(sideBar.aboutLinkIDisplayed());
        assertFalse(sideBar.resetLinkIDisplayed());
        assertFalse(sideBar.logOutLinkIDisplayed());
        }

        @Test
        public void resetAppStateCorrectly(){
            LoginPage loginPage = new LoginPage(driver);
            User validUser = new User(validUserName, validPassword);
            loginPage.successLogin(validUser);

            InventoryPage inventoryPage = new InventoryPage(driver);
            assertTrue(inventoryPage.inventoryContainerIsDisplayed());
            inventoryPage.clickOnBackpackAddToCart();
            inventoryPage.clickOnBikeLichtAddToCart();

            SideBar sideBar = new SideBar(driver);
            assertTrue(sideBar.cartBadgeIsDisplayed());

            sideBar.openSideBar();
            sideBar.clickOnResetApp();
            sideBar.closeSideBar();
            assertTrue(sideBar.cartBadgeIsNotDisplayed());






        }

}
