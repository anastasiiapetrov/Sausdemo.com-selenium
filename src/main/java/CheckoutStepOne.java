import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOne extends BasePage{

    public CheckoutStepOne(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Zip/Postal Code']")
    private WebElement zipCode;

    @FindBy(id = "continue")
    private WebElement continueButton;


    public void inputAllFields(){
        firstName.sendKeys("Elton");
        lastName.sendKeys("John");
        zipCode.sendKeys("842364");
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }


}
