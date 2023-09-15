import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.*;

import static org.junit.Assert.assertEquals;
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

    @FindBy(className = "inventory_item_price")
    private List<WebElement> inventoryPrices;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryName;


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
        clickOnTheElement(productSortContainer);
        clickOnTheElement(sortPriceLowToHigh);
       // productSortContainer.click();
       // sortPriceLowToHigh.click();
    }

    public boolean checkFromLowToHigh(){
        List<Double> actualPrices = new ArrayList<Double>();
        for (WebElement price:inventoryPrices) {
       actualPrices.add(Double.parseDouble(price.getText().replaceAll("[^0-9.]", "")));
        }
        List<Double> expectedPrices = new ArrayList<Double>(actualPrices);
        Collections.sort(expectedPrices);
        return actualPrices.equals(expectedPrices);
    }

    public boolean checkFromHighToLow(){
        List<Double> actualPrices = new ArrayList<Double>();
        for (WebElement price:inventoryPrices) {
            actualPrices.add(Double.parseDouble(price.getText().replaceAll("[^0-9.]", "")));
        }
        List<Double> expectedPrices = new ArrayList<Double>(actualPrices);
        expectedPrices.sort(Collections.reverseOrder());
        return actualPrices.equals(expectedPrices);
    }

    public boolean checkFormAtoZ(){
        List<String> actualName = new ArrayList<String>();
        for (WebElement name:inventoryName) {
            actualName.add(name.getText());
        }
        List<String> expectedName = new ArrayList<String>(actualName);
        Collections.sort(expectedName);
        return actualName.equals(expectedName);
    }

    public boolean checkFormZtoA(){
        List<String> actualName = new ArrayList<String>();
        for (WebElement name:inventoryName) {
            actualName.add(name.getText());
        }
        List<String> expectedName = new ArrayList<String>(actualName);
        expectedName.sort(Collections.reverseOrder());
        return actualName.equals(expectedName);
    }


    public void clickOnSortPriceHighToLow(){
        productSortContainer.click();
        sortPriceHighToLow.click();
    }





}
