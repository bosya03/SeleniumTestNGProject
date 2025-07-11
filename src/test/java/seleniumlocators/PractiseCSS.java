package seleniumlocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PractiseCSS {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        Faker faker = new Faker();
        WebElement fullName = driver.findElement(By.cssSelector("#userName"));
        fullName.sendKeys(faker.name().fullName());

        WebElement email = driver.findElement(By.cssSelector("#userEmail"));
        email.sendKeys("example2025@gmail.com");

        WebElement currentAddress = driver.findElement(By.cssSelector("#currentAddress"));
        currentAddress.sendKeys(faker.address().fullAddress());

        WebElement permanentAddress = driver.findElement(By.cssSelector("#permanentAddress"));
        permanentAddress.sendKeys(faker.address().fullAddress());

        WebElement submitButton = driver.findElement(By.cssSelector("button[id='submit']"));
        submitButton.click();

        WebElement result = driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12']"));
        System.out.println(result.getText());

        driver.quit();














    }
}
