package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IntroToIFrame {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/frames");

//        WebElement textToGet = driver.findElement(By.xpath("//div[@id='frame1Wrapper']/preceding-sibling::div"));
//        System.out.println(textToGet.getText());

        driver.switchTo().frame("frame1"); //1
        driver.switchTo().frame("frame1");

        WebElement textInsideIframe = driver.findElement(By.tagName("h1"));
        System.out.println(textInsideIframe.getText());

        driver.switchTo().parentFrame();

        //driver.findElement(By.xpath("//span[.='Browser Windows']")).click();


    }
}
