package seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait times for the elements

        driver.get("file:///Users/erbol/Desktop/codeWiseWebsite.html");

        //LOCATOR TAG NAME ->
        WebElement javaVersion = driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());


        //LOCATOR LINKTEXT: mostly link text is unique
        // it must have " a " tag with text
        // <a href="https://www.oracle.com/java/">Java</a>

        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();


        //task

        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        System.out.println(javaHeader.getText());

        Thread.sleep(2000);

        driver.navigate().back();

        WebElement seleniumPage = driver.findElement(By.linkText("Selenium"));
        seleniumPage.click();

        Thread.sleep(2000);

        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader.getText());

        driver.navigate().back();


        //LOCATOR PARTIAL - LINKTEXT
        // difference from linktext is you can just provide part of the text Sele (Selenium)n 2



    }
}
