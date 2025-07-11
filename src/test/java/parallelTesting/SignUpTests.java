package parallelTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignUpTests {

    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setUp (String browser) {

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();

        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();

        }
    }

    @Test
    public void signUpWithEmail () throws InterruptedException {
        driver.get("https://www.cars.com/");
        Thread.sleep(2000);
    }

    @Test
    public void signUpWithMobile () throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    public void invalidSignUp () throws InterruptedException {
        Thread.sleep(2000);
    }
}
