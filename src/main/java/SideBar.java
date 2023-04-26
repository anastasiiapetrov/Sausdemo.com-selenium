import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class SideBar extends BasePage{

    @FindBy(className = "bm-menu-wrap")
    WebElement sideBarMenu;

    @FindBy(id = "react-burger-menu-btn")
    WebElement openSideBarButton;

    @FindBy(id = "react-burger-cross-btn")
    WebElement crossSideBarButton;

    @FindBy(id = "about_sidebar_link")
    WebElement aboutLink;

    @FindBy(id = "inventory_sidebar_link")
    WebElement allItemsLink;

    @FindBy(id = "logout_sidebar_link")
    WebElement logOutLink;

    @FindBy(id = "reset_sidebar_link")
    WebElement resetLink;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;


    public SideBar(WebDriver driver) {
        super(driver);

    }

    public boolean aboutLinkIDisplayed() {

        return aboutLink.isDisplayed();
    }
    public boolean allItemLinkIDisplayed() {
        return allItemsLink.isDisplayed();
    }
    public boolean logOutLinkIDisplayed(){
        return logOutLink.isDisplayed();
    }
    public boolean resetLinkIDisplayed(){
        return resetLink.isDisplayed();
    }
    public boolean crossSideBarButtonIDisplayed(){
        return crossSideBarButton.isDisplayed();
    }


    public void openSideBar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(openSideBarButton));
        openSideBarButton.click();
       // wait.until(ExpectedConditions.visibilityOf(sideBarMenu));
    }

    public void closeSideBar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(allItemsLink));
        crossSideBarButton.click();
    }

    public void sideBarHasHidden(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(sideBarMenu));

    }

    public void clickOnResetApp(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(resetLink));
        resetLink.click();
    }

    public void clickOnLogoutLink(){
        logOutLink.click();
    }

    public boolean cartBadgeIsDisplayed(){
       return cartBadge.isDisplayed();
    }

    public boolean cartBadgeIsNotDisplayed(){
        boolean empty = false;
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOf(cartBadge));
        }catch (Exception e){
            empty=true;
        }
        return empty;
    }


}