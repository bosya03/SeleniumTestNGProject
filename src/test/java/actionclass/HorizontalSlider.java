package actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HorizontalSlider {

    @Test
    public void horizontalSlider () throws InterruptedException {

        //interview question, how do you handle sliders (or vertical or horizontal) in Automation ?
        // I use KEYS class to call ARROW - RIGHT / LEFT / UP / DOWN
        // KEYS class is all about "KEYBOARD" actions



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.tagName("input"));

        WebElement range = driver.findElement(By.xpath("//span[@id='range']"));

        String expectedRange = "3.5";

        while (!range.getText().equals(expectedRange)) {

            slider.sendKeys(Keys.ARROW_RIGHT); //press right button on the keyboard
            Thread.sleep(2000);

        }

        //MUST VALIDATE, IF YOU DON'T, IT WILL BE A WASTE
        Assert.assertEquals(range.getText(), expectedRange);


    }
}
