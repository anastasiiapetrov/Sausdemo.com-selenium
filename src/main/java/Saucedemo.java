import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Saucedemo {

    ChromeDriver driver;
    String BASE_URL = "https://www.saucedemo.com/";


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/anastasiiapetrova/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(BASE_URL);
    }


    @Test
    public void loginWithValidData() throws InterruptedException {
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

       assertTrue(driver.getCurrentUrl().contains("inventory"));

       WebElement inventoryContainer = driver.findElements(By.id("inventory_container")).get(0);
       assertTrue(inventoryContainer.isDisplayed());
    }

    @Test
    public void loginWithLockedOutUser() throws InterruptedException {
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("locked_out_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        sleep(10000);
        WebElement errorButton =
                driver.findElement(By.xpath("//button[@class='error-button']"));
       assertTrue(errorButton.isDisplayed());

      WebElement h3 =driver.findElement(By.tagName("h3"));
        assertEquals("Epic sadface: Sorry, this user has been locked out.", h3.getText());

        assertTrue(h3.getText().contains("Sorry, this user has been locked out."));

    }

    @Test
    public void loginWithInvalidData() throws InterruptedException {
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("dkwfjfbks");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        sleep(10000);
        WebElement errorButton =
                driver.findElement(By.xpath("//button[@class='error-button']"));
        assertTrue(errorButton.isDisplayed());
        WebElement h3 =driver.findElement(By.tagName("h3"));
        assertTrue(h3.getText().contains("Username and password do not match any user in this service"));
    }

        @After
        public void tearDown(){
            driver.quit();
        }
}
