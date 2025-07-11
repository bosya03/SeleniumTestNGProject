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

public class DragAndDropValidateColor {


    @Test
    public void practice () throws InterruptedException {

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
        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));

        String actualText = orangeBox.getText();
        String expectedText = "... Or here.";
        Assert.assertEquals(actualText, expectedText);

        actions.dragAndDrop(blueCircle, orangeBox).perform();

        //reassign the orange box

        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        actualText = orangeBox.getText();
        expectedText = "You did great!";

        Assert.assertEquals(actualText, expectedText);

        String actualColorValue = orangeBox.getCssValue("background-color"); //It validates the background-color
        String expectedColor = "rgba(238, 111, 11, 1)";

        Assert.assertEquals(actualColorValue, expectedColor);

    }

    @Test
    public void practice2 () {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement textBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));

        String actualText = textBox.getText();
        String expectedText = "Drop here";
        Assert.assertEquals(actualText, expectedText);




        WebElement dragMeSource = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropHereTarget = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeSource, dropHereTarget).perform();
        actions.contextClick();



        dropHereTarget = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));

        actualText = dropHereTarget.getText();
        expectedText = "Dropped!";
        Assert.assertEquals(actualText, expectedText);

        String actualColor = dropHereTarget.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor, expectedColor);


    }
}
