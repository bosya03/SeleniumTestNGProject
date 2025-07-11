package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    // Browser utils - interview question
    // can you tell me what is browser utils ?
    // custom utility class that provides reusable methods for common (repetitive) browser actions
    // like waiting, clicking, or switching windows.
    // what type of methods do you use in B/U ?
    // we use reusable methods in B/U


    public static void selectBy (WebElement location, String attributeValue, String method) {

        Select select = new Select(location);

        method = method.toLowerCase();

        switch (method) {

            case "text":
            select.selectByVisibleText(attributeValue);
            break;

            case "value":
            select.selectByValue(attributeValue);
            break;

            case "index":
            select.selectByIndex(Integer.parseInt(attributeValue));
            break;

            default:
                Assert.fail(" The value that you provided is not one of the text, value or index ");

        }

    }



    public static void clickJS (WebDriver driver, WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);


    }

    public static void scrollWithJS (WebDriver driver, WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);

    }

    public static void switchWindow (WebDriver driver, String title) {

        Set<String> pageIDs = driver.getWindowHandles();

        for(String id:pageIDs) {

            driver.switchTo().window(id); //no matter what switch your window
            if(driver.getTitle().contains(title)) {
                break;
            }
        }


    }
}
