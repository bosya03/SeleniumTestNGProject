package windowmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Windows {

    @Test
    public void test1 () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement firstName = driver.findElement(By.cssSelector("input[id ='user-name']"));
        firstName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("input[id ='password']"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.cssSelector("input[id ='login-button']"));
        login.click();

        String mainWindowHandle = driver.getWindowHandle();

        WebElement twitter = driver.findElement(By.xpath("//a[.='Twitter']"));
       // BrowserUtils.scrollWithJS(driver, twitter);
        twitter.click();


        for (String windowHandle : driver.getWindowHandles()) {
            if (!mainWindowHandle.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);

            }
        }

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(mainWindowHandle);
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(2000);


        WebElement facebook = driver.findElement(By.xpath("//a[.='Facebook']"));
        BrowserUtils.scrollWithJS(driver, facebook);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", facebook);
        driver.close();



        WebElement linkdn = driver.findElement(By.xpath("//a[.='LinkedIn']"));
        BrowserUtils.scrollWithJS(driver, linkdn);

        js.executeScript("arguments[0].click()", linkdn);



    }

    public void clickOnSocialMedia (WebDriver driver, String mainWindowHandle, WebElement socialMediaButton) {

        // this method is reusable for clicking on social medias
        // because it's now recommended to repeat yourself, just create a reusable method
        
        JavascriptExecutor js = (JavascriptExecutor) driver;


    }
}
