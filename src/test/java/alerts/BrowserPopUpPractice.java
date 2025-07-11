package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserPopUpPractice {

    @Test
    public void regularBrowser () {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/geolocation");

        WebElement button = driver.findElement(By.xpath("//button[@onclick='getLocation()']"));
        button.click();





    }

    @Test
    public void browserWithDisabledLocation () {

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation", 0);

        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/geolocation");

        WebElement button = driver.findElement(By.xpath("//button[@onclick='getLocation()']"));
        button.click();





    }
}
