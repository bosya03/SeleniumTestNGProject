package mybankproject.qa.bank.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;

public class TestBase {

    // TestBase - is a class that we store our "SETUP AUTOMATION" and "TEAR DOWN" - (closing page)
    // where we do set up and quit, before method and after method

    public WebDriver driver;

    @BeforeMethod
    public void setUp () { // it runs before each @Test annotation

        driver = Driver.getDriver("chrome");
        driver.navigate().to(ConfigReader.readProperty("sauce-lab-url"));

//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.saucedemo.com/");

    }

    @AfterMethod
    public void tearDown () { // it runs after each @Test annotation

       driver.quit();

    }

}
