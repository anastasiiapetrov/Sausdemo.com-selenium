import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class InventoryPage extends BasePage{

    @FindBy(xpath = "(//div[@id='inventory_container'])[1]")
    private WebElement inventoryContainer;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> productCards;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement tShirtAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightAddToCart;

    @FindBy(id= "shopping_cart_container")
    private WebElement cartIcon;

   @FindBy(xpath = "(//div[@class='inventory_item_price'])[1]")
    private WebElement price;

   @FindBy(className = "product_sort_container")
   private WebElement productSortContainer;

   @FindBy(xpath = "//option[@value='az']")
   private WebElement sortNameAtoZ;

    @FindBy(xpath = "//option[@value='za']")
    private WebElement sortNameZtoA;

    @FindBy(xpath = "//option[@value='lohi']")
    private WebElement sortPriceLowToHigh;

    @FindBy(xpath = "//option[@value='hilo']")
    private WebElement sortPriceHighToLow;

    @FindBy(xpath = "//div[@class='inventory_item_name'][1]")
    WebElement firstItemName;

    @FindBy(xpath = "//div[@class='inventory_item_price'][1]")
    WebElement firstItemPrice;


    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean inventoryContainerIsDisplayed(){
        return inventoryContainer.isDisplayed();
    }

    public void allProductCardsAreVisible(){
        for (WebElement card:
             productCards) {
    assertTrue(card.isDisplayed());
        }
    }

    public void clickOnBackpackAddToCart(){
        backpackAddToCartButton.click();
    }

    public void clickOnTShirtAddToCart(){
        tShirtAddToCart.click();
    }

    public void clickOnBikeLichtAddToCart(){
        bikeLightAddToCart.click();
    }

    public void clickOnCartIcon(){
       cartIcon.click();
    }

    public String checkPriceOnInventoryPage(){
       return price.getText();
    }


    public void clickOnSortNameAtoZ(){
        productSortContainer.click();
        sortNameAtoZ.click();
    }
    public void clickOnSortNameZtoA(){
        productSortContainer.click();
        sortNameZtoA.click();
    }
    public void clickOnSortPriceLowToHigh(){
        productSortContainer.click();
        sortPriceLowToHigh.click();
    }
    public void clickOnSortPriceHighToLow(){
        productSortContainer.click();
        sortPriceHighToLow.click();
    }





}
