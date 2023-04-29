import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id ="password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement header;

    @FindBy(id= "login_credentials")
    private WebElement loginField;

    @FindBy(xpath = "//div[@class='login_password']")
    private WebElement passwordField;

    @FindBy(className = "login_credentials_wrap-inner")
    private WebElement loginCredentialsField;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterValueUserName (User user){
        enterTextToElement(user.getUsername(), userName);
        return this;
    }

    public LoginPage enterValuePassword(User user){
        enterTextToElement(user.getPassword(), password);
        return this;
    }

    public InventoryPage pushLoginButton(){
        clickOnTheElement(loginButton);
        return new InventoryPage(driver);

    }

    public void successLogin (User user){
        enterTextToElement(user.getUsername(), userName);
        enterTextToElement(user.getPassword(), password);
        clickOnTheElement(loginButton);
    }

    public void errorMessageValue(String expectedText){
        assertTrue(errorMessage.getText().contains(expectedText));
    }

    public String getErrorMessageText(){
        return getTextOfElement(errorMessage);
    }

    public boolean headerIsVisible(){
        return header.isDisplayed();
    }

    public void loginFieldIsVisible(){
        assertTrue(loginField.isDisplayed());
    }

    public void passwordFieldIsVisisble(){
        assertTrue(passwordField.isDisplayed());
    }

    public boolean loginPageIsOpen(){
        return loginCredentialsField.isDisplayed();
    }


}
