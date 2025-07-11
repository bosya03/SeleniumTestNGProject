package windowmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.Driver;

public class SauceDemoPractice {

    /*

    1. go to https://www.saucedemo.com/
    2. login
    3. click on Twitter icon
    4. print title and url of Twitter
    5. come back to the main page
    6. click on Facebook icon
    7. print title and url of Facebook
    8. come back to the main page
    9. click on Linkedin icon
    10. print title and url of Linkedin


     */

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = Driver.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");

        login();




//        driver = new ChromeDriver();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/");

    }


    @Test
    public void testSocialMediaButtons() {

        String mainWindowHandle = driver.getWindowHandle();

        WebElement twitter = driver.findElement(By.xpath("//a[.='Twitter']"));
        clickOnSocialMediaButton(driver, mainWindowHandle, twitter);

        WebElement facebook = driver.findElement(By.xpath("//a[.='Facebook']"));
        clickOnSocialMediaButton(driver, mainWindowHandle, facebook);

        WebElement linkedin = driver.findElement(By.xpath("//a[.='LinkedIn']"));
        clickOnSocialMediaButton(driver, mainWindowHandle, linkedin);
    }

    public void login() {

        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.cssSelector("#login-button"));
        login.click();

    }

    public void clickOnSocialMediaButton (WebDriver driver, String mainWindowHandle, WebElement socialMediaButton) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        BrowserUtils.scrollWithJS(driver, socialMediaButton);
        js.executeScript("arguments[0].click()", socialMediaButton);

        for (String windowHandle : driver.getWindowHandles()){
            if (!mainWindowHandle.equals(windowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(mainWindowHandle);
        System.out.println(driver.getCurrentUrl());

    }
}
