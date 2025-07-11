package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class IntroToAlerts {

    WebDriver driver = new ChromeDriver();


    @BeforeMethod
    public void engine () {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/alerts");

    }


    @Test
    public void acceptAlertTest () throws InterruptedException {

        WebElement clickAlert = driver.findElement(By.cssSelector("#alertButton"));
        clickAlert.click();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        driver.navigate().back();

    }

    @Test
    public void dismissAlert () throws InterruptedException {

        WebElement dismissAlert = driver.findElement(By.cssSelector("#confirmButton"));
        dismissAlert.click();
        driver.switchTo().alert().dismiss();

        driver.navigate().back();

        Thread.sleep(2000);

    }

    @Test
    public void sendKeysAcceptAlerts () throws InterruptedException {

        WebElement promptButton = driver.findElement(By.cssSelector("#promtButton"));
        promptButton.click();

        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("Chicago");
        driver.switchTo().alert().accept();

        driver.navigate().back();


    }
}
