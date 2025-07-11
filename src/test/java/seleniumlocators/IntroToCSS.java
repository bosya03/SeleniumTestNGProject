package seleniumlocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntroToCSS {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement firstName = driver.findElement(By.cssSelector("input[id ='user-name']"));
        firstName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("input[id ='password']"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.cssSelector("input[id ='login-button']"));
        login.click();


        String correctURL = driver.getCurrentUrl();
        if (correctURL.contains("inventory.html")) {
            System.out.println("URL is passed");
        } else {
            System.out.println("URL is failed");
        }

        //step 2

        WebElement backpack = driver.findElement(By.cssSelector("button[id='add-to-cart-sauce-labs-backpack']"));
        backpack.click();

        WebElement tShirt = driver.findElement(By.cssSelector("button[id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        tShirt.click();

        WebElement openCart = driver.findElement(By.cssSelector("a[data-test='shopping-cart-link']"));
        openCart.click();


        WebElement checkoutButton = driver.findElement(By.cssSelector("button[id='checkout']"));
        checkoutButton.click();




        Faker faker = new Faker();


        WebElement firstName1 = driver.findElement(By.cssSelector("input[id='first-name']"));
        firstName1.sendKeys(faker.name().firstName());


        WebElement lastName1 = driver.findElement(By.cssSelector("input[id='last-name']"));
        lastName1.sendKeys(faker.name().lastName());


        WebElement zipCode = driver.findElement(By.cssSelector("input[id='postal-code']"));
        zipCode.sendKeys("15106");


        WebElement continueButton = driver.findElement(By.cssSelector("input[id='continue']"));
        continueButton.click();

        WebElement finishButton = driver.findElement(By.cssSelector("button[id='finish']"));
        finishButton.click();


        WebElement thanksText = driver.findElement(By.cssSelector("h2[class='complete-header']"));

        if (thanksText.isDisplayed()) {
            System.out.println("Order is confirmed !");
        } else {
            System.out.println("ERROR !!!");
        }

        driver.quit();


        //test failure rate interview question
        // test rate more than 90 is considered good

        //sometimes test is not working, it's ok, maybe it works on your comp,
        // but it doesn't on another comp




    }

}
