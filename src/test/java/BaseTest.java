import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.rules.TestWatcher;

import java.time.Duration;

public class BaseTest {
   public static ChromeDriver driver;
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

    public String validUserName = "standard_user";

    public String lockedOutUserName = "locked_out_user";

    public String invalidUserName = "jbhdfvkjdb";

    public String validPassword = "secret_sauce";
    public String invalidUserPassword = "ejvfjdvkdf";

    @After
    public void tearDown(){
        driver.quit();
    }

   /* @Rule
    public TestWatcher screenShot = new TestWatcher(){
       @Override
        protected  void failed(Throwable e, Description description){
           makeScreenshotOnFailure(){
               return((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
           }
       }
    }*/



}
