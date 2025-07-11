package homeassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathWork {
    public static void main(String[] args) throws InterruptedException {

        //    1. go to https://magento.softwaretestingboard.com/
        //    2. search 'Pants', hit enter
        //    3. choose size 32, color gray of 'Caesar Warm-Up Pant'
        //    4. click on 'Add to Cart'
        //    5. go to cart
        //
        //    REQUIREMENT: YOU MUST USE XPATH WITH METHODS: TEXT, CONTAINS, STARTS-WITH



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://magento.softwaretestingboard.com/");

        WebElement searchButton = driver.findElement(By.xpath("//input[contains(@placeholder, 'store here')]"));

        //starts-with method
        //input[starts-with(@placeholder, 'Search')]

        searchButton.sendKeys("Pants" + Keys.ENTER);

        WebElement pantsSize = driver.findElement(By.xpath("//a[contains(text(), 'Caesar Warm-Up Pant')]/../..//div[text()='32']"));
        pantsSize.click();

        WebElement pantColor = driver.findElement(By.xpath("//a[contains(text(), 'Caesar Warm-Up Pant')]/../../..//div[@aria-label='Gray']"));
        pantColor.click();

        WebElement addButton = driver.findElement(By.xpath("//a[contains(text(), 'Caesar Warm-Up Pant')]/../../..//button[@title='Add to Cart']"));
        addButton.click();

        Thread.sleep(2000);

        WebElement goToCart = driver.findElement(By.xpath("//a[@class='action showcart']"));
        goToCart.click();

        WebElement proceedToCheckout = driver.findElement(By.xpath("//button[contains(text(), 'Proceed to Checkout')]"));
        proceedToCheckout.click();

    }
}
