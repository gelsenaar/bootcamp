package general;

import Browser.BrowserFactoryAdvanced;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Gerrit Elsenaar on 20-7-2017.
 */
public class TestShopScenario {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
//        ChromeDriverManager.getInstance().setup();
//        driver = new ChromeDriver();
//        Bovenstaande 2 regels worden vervangen door:

        String browserName = "CHROME";

        driver = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.Browser.CHROME);
        driver.get("https://techblog.polteq.com/testshop/index.php");

        /*if (browserName.toLowerCase().equals("firefox") || browserName.toLowerCase().equals("ie")) {
            //driver.manage().window().maximize();
        } else {
            driver.manage().window().maximize();
        }*/
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}
