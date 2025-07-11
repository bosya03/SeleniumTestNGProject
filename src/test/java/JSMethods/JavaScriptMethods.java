package JSMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JavaScriptMethods {

    @Test
    public void javaScriptMethods () {

        //Web sites are build by JavaScript,
        // and that's why java script works good together with WebSites
        // js works with DOM, it doesn't care about pop ups (facebook case)
        // Ahmet's personal opinion, better first use java methods (regular clicks)
        // if you use js click, it will ignore pop up or error message,
        // and in case that error was not caught, it will go to production and
        // you will have problems brotha

        //sometimes click, actions click.perform will not work, then, the last hope is JS Methods 99 %
        //INTERVIEW QUESTION - how do you scroll into the page
        // I use -> JS SCROLLINTOVIEW METHOD
        // JS

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codewise.academy/");

        WebElement watchVideo = driver.findElement(By.linkText("Watch Presentation"));

        //watchVideo.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click()", watchVideo);


    }

    @Test
    public void newTest () {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.cssSelector("#yesRadio"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", yesButton);

        WebElement validateText = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualText = validateText.getText();
        String expectedText = "You have selected Yes";
        Assert.assertEquals(actualText, expectedText);


    }

    @Test
    public void applyJSUtils () {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.cssSelector("#yesRadio"));

        BrowserUtils.clickJS(driver, yesButton);

        WebElement validateText = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualText = validateText.getText();
        String expectedText = "You have selected Yes";
        Assert.assertEquals(actualText, expectedText);



    }


    @Test
    public void scrollIntoViewPractice () throws InterruptedException {

        //if you don't scroll your view and try to do element to be visible, it will not work, use scroll methods

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codewise.academy/");

        WebElement instructorAhmet = driver.findElement(By.xpath("//div[.='Ahmet']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        BrowserUtils.scrollWithJS(driver, instructorAhmet);

//        js.executeScript("arguments[0].scrollIntoView(true)", instructorAhmet);
        //true means, keep scrolling up / down until you find that web element

        Thread.sleep(2000);

        WebElement itCareerScrollUp = driver.findElement(By.xpath("//div[contains(text(), 'Start your ')]"));
        //js.executeScript("arguments[0].scrollIntoView(true)", itCareerScrollUp);
        BrowserUtils.scrollWithJS(driver, itCareerScrollUp);



    }

    @Test
    public void practiceScroll(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button3=driver.findElement(By.cssSelector("#newWindowsBtn"));
        BrowserUtils.scrollWithJS(driver,button3);
        button3.click();
    }

}
