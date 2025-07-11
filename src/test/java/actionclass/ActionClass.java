package actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionClass {

    @Test
    public void ContextClick () {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");

        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));

        Actions actions=new Actions(driver); //will handle all the actions methods (create only one)

        //******* DO NOT FORGET PERFORM AT THE END***********
        actions.contextClick(box).perform();


    }
    @Test
    public void practice () {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");



        WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        //span[contains(text(), 'click me')]

        Actions actions = new Actions(driver);

        actions.click(button).perform();







    }



    @Test
    public void doubleClick () {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement doubleClick = driver.findElement(By.xpath("//button[contains(text(), 'Double-Click')]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).perform();

        driver.quit();


    }
}
