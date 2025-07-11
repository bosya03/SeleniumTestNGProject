package actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class MoveElementsGetRealProducts {

    @Test
    public void validateText() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        List<WebElement> allUsers = driver.findElements(By.xpath("//h5"));
        List<WebElement> allPictures = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<String> expectedUsers = Arrays.asList("name: user1", "name: user2", "name: user3");
        Actions actions = new Actions(driver);

        for (int i = 0; i < allPictures.size(); i++) {
            //this will hover-over each picture one by one
            actions.moveToElement(allPictures.get(i)).perform();

            //I am getting the text one by one
            System.out.println(allUsers.get(i).getText());

            //It is the way of validation the list of usernames
            Assert.assertEquals(allUsers.get(i).getText(), expectedUsers.get(i));
            Thread.sleep(2000);


        }
    }



    @Test
    public void getProducts () throws InterruptedException {

                   /*
        1-Navigate to the website https://demos.telerik.com/kendo-ui/fx/expand
        2-Accept Cookies if it pop ups.(Be careful about timing)
        3-Use actions.scrollByAmount(400,400) or any number to make sure the items look good on your screen if it necessary
        4-Get the all images location as a list
        5-Get the all Names location as a list
        6-Get the all Price location as a list
        7-Inside of regular loop Use actions move to element and put in the map (Key will be name , Value will be Price)
        8-Outside of loop, print out Map
        9-Proud of Yourself
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");

        Actions actions = new Actions(driver);
        actions.scrollByAmount(300, 300);

        List<WebElement> allImages = driver.findElements(By.xpath("//div[@class='product k-listview-item']"));
        List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='product-description']"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='product-description']/child::p"));


        HashMap<String, String> productsInfo = new HashMap<>();

        for (int i = 0; i < allImages.size(); i ++) {

            actions.moveToElement(allImages.get(i)).perform();
            Thread.sleep(1000);

            String productsNames = allNames.get(i).getText();
            String productsPrices = allPrices.get(i).getText();

            productsInfo.put(productsNames, productsPrices);


        }

        System.out.println(productsInfo);
        driver.quit();

    }
}
