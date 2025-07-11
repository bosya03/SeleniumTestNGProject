package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    static WebDriver driver;

    public static WebDriver getDriver (String browser) {


        switch (browser) {

            case "chrome" :
                driver = new ChromeDriver();
                break;

            case "firefox" :
                driver = new FirefoxDriver();
                break;

            case "edge" :
                driver = new EdgeDriver();
                break;

            case "safari" :
                driver = new SafariDriver();
                break;

            default:
                throw new IllegalArgumentException(" Browser type is incorrect." +
                        " Please choose : chrome, firefox, edge, safari ");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;

    }

    public static void closeDriver () {

        if (driver != null) {
            driver.quit();
            driver = null;
             
        }
    }
}
