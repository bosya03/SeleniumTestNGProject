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

import java.time.Duration;

public class ClickAndHoldMethod {

    // SOMETIMES DRAG AND DROP WILL NOT WORK, HERE IS THE ALTERNATIVE WAY


    @Test
    public void clickAndHold () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        // Thread.sleep(2000); // not good, it slows the system
        Actions actions = new Actions(driver);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Accept')]")));
        WebElement acceptCookies = driver.findElement(By.xpath("//button[contains(text(), 'Accept')]"));

        Thread.sleep(2000);
        actions.click(acceptCookies).perform();

        actions.scrollByAmount(300, 300);

        WebElement blueCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));

        String actualText = blueBox.getText();
        String expectedText = "Drag the small circle here ...";

        Assert.assertEquals(actualText, expectedText);

        actions.clickAndHold(blueCircle).moveToElement(blueBox).release().perform();
        //release - stop holding the mouse


        //StaleElementReferenceException, to solve i ------> REASSIGN

        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        actualText = blueBox.getText();
        expectedText = "You did great!";

        Assert.assertEquals(actualText, expectedText);



    }

    @Test
    public void clickAndHold2 () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

                         /*
        1-Navigate to the website
          -->Click Accept Button with actions.click(Accept).perform
        2-Validate the text is Box text is "Drop here"
        3-Click and Hold Not acceptable box and release into Box
        4-Validate the box text is still "Drop here"
        5-Click and Hold Acceptable box and release into Box
        6-Validate box text is "Dropped!"

         */

        Actions actions = new Actions(driver);

        WebElement acceptPage = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        actions.click(acceptPage).perform();

        Thread.sleep(2000);

        actions.scrollByAmount(300,300).perform();

        WebElement textBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']/p"));

        String actualText = textBox.getText();
        String expectedText = "Drop here";
        Assert.assertEquals(actualText, expectedText);

        Thread.sleep(2000); //to manually handle the pop up, in real life there will be no that

        WebElement notAcceptable = driver.findElement(By.cssSelector("#notAcceptable"));
        WebElement dropHereBox = driver.findElement(By.xpath("//div[@id='notAcceptable']/following::div[@id='droppable']"));

        actions.clickAndHold(notAcceptable).moveToElement(dropHereBox).release().perform();

        textBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']/p"));
        actualText = textBox.getText();
        expectedText = "Drop here";
        Assert.assertEquals(actualText, expectedText);

        WebElement acceptableSource = driver.findElement(By.cssSelector("#acceptable"));
        dropHereBox = driver.findElement(By.xpath("//div[@id='notAcceptable']/following::div[@id='droppable']"));

        actions.clickAndHold(acceptableSource).moveToElement(dropHereBox).release().perform();

        actualText = textBox.getText();
        expectedText = "Dropped!";
        Assert.assertEquals(actualText, expectedText);

        //validate still there
        //div[@id='acceptDropContainer']//div[@id='droppable']/p

        //text here
        //div[@class='accept-drop-container']//p


    }
}
