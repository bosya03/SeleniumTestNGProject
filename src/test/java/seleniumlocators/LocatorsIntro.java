package seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/erbol/Desktop/codeWiseWebsite.html");

        //LOCATOR ID
        WebElement header = driver.findElement(By.id("codewise1"));

        String actualHeaders = header.getText();
        String expectedHeader = "CodeWise Academy";

        System.out.println(actualHeaders.equals(expectedHeader) ? "Header is passed" : "Header ain't passed");


        //print out the paragraph
        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());



        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Erbol");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Baktiiar");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("412 - 519 - 9408");

        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("erbol.baktiiar2025@gmail.com");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("14 Devon Ave");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Pittsburgh");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("PA");

        WebElement postalCode = driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("15106");

        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());

        //pkill Chrome - deletes Chrome windows

        WebElement javaBox = driver.findElement(By.id("cond1"));

        if (javaBox.isDisplayed() && javaBox.isEnabled() && !javaBox.isSelected()) {
            javaBox.click();
        }

        WebElement testNGBox = driver.findElement(By.id("cond3"));
        if (testNGBox.isDisplayed() && testNGBox.isEnabled() && !testNGBox.isSelected()) {
            testNGBox.click();
        }

        Thread.sleep(2000);

        WebElement cucumberBox = driver.findElement(By.id("cond4"));
        if (cucumberBox.isDisplayed() && cucumberBox.isEnabled() && !cucumberBox.isSelected()) {
            cucumberBox.click();
        }


    }
}
