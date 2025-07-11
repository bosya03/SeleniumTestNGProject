package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertPractice3 {

    @Test
    public void jsAlert () throws InterruptedException {

                /*
        1. go to https://the-internet.herokuapp.com/javascript_alerts
        2. click on JS Alert
        3. print alert's text
        4. accept alert
        5. click on JS Confirm
        6. print alert's text
        7. dismiss alert
        8. click on JS Prompt
        9. print alert's text
        10. send some keys
        11. accept alert
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
      //  driver.navigate().back();
        Thread.sleep(2000);


        WebElement jsConfirm = driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]"));
        jsConfirm.click();
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
      //  driver.navigate().back();




        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().sendKeys("Il");
        driver.switchTo().alert().accept();


        driver.quit();

    }
}
