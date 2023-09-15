import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class LoginTests extends BaseTest{


@Test
    public void loginWithValidData()  {
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.enterValueUserName(validUser);
        loginPage.enterValuePassword(validUser);
       assertTrue(loginPage.pushLoginButton().inventoryContainerIsDisplayed()); //заменили нижние строки на это

      //  loginPage.enterValueUserName(validUser)
        //                .enterValuePassword(validUser)
        //                        .pushLoginButton(); second version how to write it or how above - цепочка методов


        assertTrue(driver.getCurrentUrl().contains("inventory"));
       // InventoryPage inventoryPage = new InventoryPage(driver);
       // assertTrue(inventoryPage.inventoryContainerIsDisplayed());
    }


    public void loginWithLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        User lockedOutUser = new User(lockedOutUserName, validPassword);
        loginPage.enterValueUserName(lockedOutUser);
        loginPage.enterValuePassword(lockedOutUser);
        loginPage.pushLoginButton();
        loginPage.errorMessageValue("Sorry, this user has been locked out.");

    }

@Test
    public void invalidUser(){
        LoginPage loginPage = new LoginPage(driver);
        User invalidUser = new User(invalidUserName, invalidUserPassword);
        loginPage.enterValueUserName(invalidUser);
        loginPage.enterValuePassword(invalidUser);
        loginPage.pushLoginButton();
        assertTrue(loginPage.getErrorMessageText().contains("Username and password do not match any user in this service"));
    }

@Test
    public void elementsAreDisplayed(){
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.headerIsVisible());
        loginPage.loginFieldIsVisible();
        loginPage.passwordFieldIsVisisble();

    }

    @Test
    public void successLogout(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName, validPassword);
        loginPage.successLogin(validUser);

        SideBar sideBar= new SideBar(driver);
        sideBar.openSideBar();
        sideBar.clickOnLogoutLink();

      assertTrue(loginPage.loginPageIsOpen());

    }



}
