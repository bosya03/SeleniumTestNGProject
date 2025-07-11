package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertPractice2 {


    @Test
    public void clickAndSubmit () {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        WebElement enterText = driver.findElement(By.xpath("//input[@name='cusid']"));
        enterText.sendKeys("2025 AI");

        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.quit();


    }
}
