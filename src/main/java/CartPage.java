import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Double.parseDouble;
import static org.junit.Assert.assertTrue;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "cart_item")
    private List<WebElement> items;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> priceCart;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;


    public boolean firstItemIsDisplayed(){
        return items.get(0).isDisplayed();
    }

    public int getItemsQuantity(){
        return items.size();
    }

    public boolean allItemsAreDisplayed(){
       return allElementsCollectionAreDisplayed(items);
    }

    public boolean cartIsEmpty(){
        boolean empty = false;
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOf(items.get(0)));
        }catch (Exception e){
            empty=true;
        }
        return empty;
    }
    public String priceOnCartPage(){
        return priceCart.get(0).getText();
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }

    public double getTotalPrices(){
        double total = 0;
        for (WebElement price: priceCart) {
           total+= parseDouble(price.getText().substring(1));


        }
        return total;
    }
}
