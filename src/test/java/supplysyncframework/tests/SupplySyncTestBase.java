package supplysyncframework.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;
import utils.Driver;


import java.time.Duration;

public class SupplySyncTestBase {

    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp () {

        driver = Driver.getDriver("chrome");
        driver.get(ConfigReader.readProperty("supplysync-url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown () {

        if (driver != null) {
            driver.quit();

        }
    }
}
