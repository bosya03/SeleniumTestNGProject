package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicWaits {


    @Test
    public void implicitWaitSyntax() {

        WebDriver driver = new ChromeDriver();
        // waits for element to appear on page before throwing NoSuchElementException
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        //waits for the page load to complete
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }


    @Test
    public void explicitWaitSyntax() {

        //explicit wait:
        // applied to each web element
        // you can provide timeout
        // it can wait for specific condition

        //not good practise to put lots of time
        //it's used for single web element

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element1 = driver.findElement(By.id("#first-name"));
        wait.until(ExpectedConditions.elementToBeClickable(element1));
        element1.click();

        // The element is found before the wait.
        //Then the code waits for that specific instance (element1) to become clickable.
        //This might fail if the element isn't yet present in the DOM or is in a stale state
        // (e.g., re-rendered after some JavaScript).
        //Risk: This approach can throw a NoSuchElementException
        // or StaleElementReferenceException if the element isn't ready or has changed before the wait finishes.


        wait.until(ExpectedConditions.elementToBeClickable(By.id("#last-name")));
        WebElement element2 = driver.findElement(By.id("#last-name"));
        element2.click();

        // The code waits before locating the element.
        //It waits until an element located by the given locator (By.id("#last-name")) is clickable.
        //Then it retrieves the element and clicks it.


    }

    @Test
    public void fluentWaitSyntax() throws InterruptedException {

        // fluent wait:
        // applied to each web element
        // you can provide timeout
        // it can wait for specific condition
        // it can ignore given exception
        // you can set polling interval

        // When we use ?
        //ex: even your locators are correct, but it keeps throwing no such el ex anyway,
        // then you can use this
        // it's okay to forget the syntax, even in interview
        // what matters is you understand the idea of fluent wait

        WebDriver driver = new ChromeDriver();
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // total timeout
                .ignoring(NoSuchElementException.class) // ignoring exception
                .pollingEvery(Duration.ofSeconds(1)); // how often do we want to check the condition

        fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("qwerty")));


        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        for (int i = 1; i <= 5; i++) {

            try {
                System.out.println("trying to click attempt -> " + i);
                loginButton.click();
                break;

            } catch (Exception e) {
                Thread.sleep(2000);


            }


        }
    }
}
