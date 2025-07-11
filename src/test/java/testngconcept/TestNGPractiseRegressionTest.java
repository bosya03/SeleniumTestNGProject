package testngconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestNGPractiseRegressionTest {

    //regression testing - means run all test and check

    @Test
    public void validateHappyPathLogin() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();


        String actualTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(actualTitle, expectedTitle);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualURL, expectedURL);

        driver.quit();


    }

    @Test
    public void validateSadPathLogin() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("public sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.tagName("h3"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualMessage, expectedMessage);

        driver.quit();


    }

    @Test
    public void validateProductInformation() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");


        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
        List<WebElement> allProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
        Assert.assertEquals(allProducts.size(), 6);
        for (WebElement product : allProducts) {
            if (product.getText().equals("Sauce Labs Bolt T-Shirt")) {
                product.click();
                break;
            }
        }
        WebElement header = driver.findElement(By.cssSelector(".inventory_details_name"));
        //I took the left side of the class value (because of the space
        String actualHeader = header.getText();
        String expectedHeader = "Sauce Labs Bolt T-Shirt";
        Assert.assertEquals(actualHeader, expectedHeader);
        WebElement desc = driver.findElement(By.xpath("//div[@data-test='inventory-item-desc']"));
        String actualDesc = desc.getText();
        String expectedDesc = "heather gray";
        Assert.assertTrue(actualDesc.contains(expectedDesc));
        WebElement price = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']"));
        String actualPrice = price.getText();
        String expectedPrice = "$15.99";
        Assert.assertEquals(actualPrice, expectedPrice);
        WebElement addToCartButton = driver.findElement(By.cssSelector("#add-to-cart"));
        Assert.assertTrue(addToCartButton.isDisplayed());

        Thread.sleep(2000);


        //step 2

        WebElement addToCartButton2 = driver.findElement(By.cssSelector("#add-to-cart"));
        addToCartButton2.click();

        WebElement cartShows1 = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));

        String validate1InCart = cartShows1.getText();
        String expected1InCart = "1";

        Assert.assertEquals(validate1InCart, expected1InCart);

        WebElement clickCartSymbol = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        clickCartSymbol.click();

        WebElement validateProductName = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String actualProductName = validateProductName.getText();
        String expectedProductName = "Sauce Labs Bolt T-Shirt";

        Assert.assertEquals(actualProductName, expectedProductName);

        WebElement checkout = driver.findElement(By.cssSelector("#checkout"));
        checkout.click();

        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        firstName.sendKeys("Erbol");

        WebElement lastName = driver.findElement(By.cssSelector("#last-name"));
        lastName.sendKeys("Bak");

        WebElement zipCode = driver.findElement(By.cssSelector("#postal-code"));
        zipCode.sendKeys("15106");

        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();

        WebElement validateTotalPrice = driver.findElement(By.xpath("//div[@class='summary_total_label']"));
        String actualTotalPrice = validateTotalPrice.getText();
        String expectedTotalPrice = "Total: $17.27";

        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);

        WebElement finishButton = driver.findElement(By.cssSelector("#finish"));
        finishButton.click();

        WebElement validateHeaderValue = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        String actualHeaderValue = validateHeaderValue.getText();
        String expectedHeaderValue = "Thank you for your order!";
        Assert.assertEquals(actualHeaderValue, expectedHeaderValue);
    }
}
