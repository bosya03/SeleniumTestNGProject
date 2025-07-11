package actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class PracticeAndWindow {


    @Test
    public void test1()  {

        // 1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
        // 2-Click Pavilion
        // 3-Hover Over Selenium then click Selenium-Phyton
        // 4-Print out all the links(only links) and validate size is 22

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://skpatro.github.io/demo/iframes/");

        // 1. Saving the Current Tab:
        // This stores the handle (unique ID) of the current browser tab/window.
        // This is usually done before an action that opens a new tab or window
        // Selenium can only interact with one tab at a time.
        // If you don’t switch to the newly opened tab, Selenium won’t “see” its elements,
        // and your test will fail.

        String firstPageWindowHandle = driver.getWindowHandle(); // D3B76A95F776E9AEFE6CB69AF8000125

        WebElement pavilion = driver.findElement(By.xpath("//a[contains(text(), 'Pavilion')]"));
        pavilion.click();

//        Set<String> windowHandles = driver.getWindowHandles();
//
//        for (String window : windowHandles) {
//            if (!window.equals(firstPageWindowHandle)) {
//                driver.switchTo().window(window);
//            }
//        }

        //browser utils with window handles to make life easier
        BrowserUtils.switchWindow(driver, "Home - qavalidation");

        Actions actions = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='primary-menu']//span[.='Selenium' and @class='menu-text']")));

        WebElement seleniumPart = driver.findElement(By.xpath("//ul[@id='primary-menu']/li[2]/a"));
        actions.moveToElement(seleniumPart).perform();

        WebElement seleniumPython = driver.findElement(By.xpath("//ul[@id='primary-menu']//li//span[@class='menu-item-text']//span[.='Selenium-Python']"));
        seleniumPython.click();

        List<WebElement> allLinks = driver.findElements(By.xpath("//p/a"));

        int actualSize = allLinks.size();
        int expectedSize = 22;

        Assert.assertEquals(actualSize, expectedSize);

        for (WebElement link : allLinks) {
            System.out.println(link.getDomAttribute("href"));
        }
    }


    @Test
    public void test2 () {

        // 1-Click the category 1 button
        // 2-Validate the header is "Category Archives: SeleniumTesting"
        // 3-Print out the top of the each box(text) and validate size is 9 I showed you during manual steps

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://skpatro.github.io/demo/iframes/");

        // 1. Saving the Current Tab:
        // This stores the handle (unique ID) of the current browser tab/window.
        // This is usually done before an action that opens a new tab or window
        // Selenium can only interact with one tab at a time.
        // If you don’t switch to the newly opened tab, Selenium won’t “see” its elements,
        // and your test will fail.

        String newTab = driver.getWindowHandle();


        WebElement iframe = driver.findElement(By.cssSelector("#Frame1"));
        driver.switchTo().frame(iframe);

        WebElement category1 = driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();

        driver.switchTo().parentFrame();

        Set<String> windowHandles = driver.getWindowHandles();
        //Returns a Set of all open window handles (i.e., all tabs/windows).


        for (String window : windowHandles) {
            if (!window.equals(newTab)) {
                driver.switchTo().window(window);
            }
        }



        WebElement header = driver.findElement(By.xpath("//h1[contains(text(), 'Category Archives:')]"));

        String actualHeader = header.getText();
        String expectedHeader = "Category Archives: SeleniumTesting";
        Assert.assertEquals(actualHeader, expectedHeader);

        List<WebElement> topTexts = driver.findElements(By.xpath("//h3/a"));

        for (WebElement text : topTexts) {
            System.out.println(text.getDomAttribute("href"));
        }

        int actualSize = topTexts.size();
        int expectedSize = 9;

        Assert.assertEquals(actualSize, expectedSize);



    }
}



