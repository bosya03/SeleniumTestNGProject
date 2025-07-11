package selectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class CarsRealPractice {



    @Test
    public void carsAutomation () throws InterruptedException {

                        /*
        NOTE: Please use browser utils for the select classes if it is needed or getText.
        1-Navigate to the website https://www.cars.com/shopping/
        2-Choose the "New & certified" from the New/used option
        3-Choose "Lexus" for Make part
        4-Choose "RX 350"
        5-Validate the Price is selected "No max price"-->getFirstSelectedOption -->regular select
        6-Choose the distance 40 miles
        7-Put your Zip code-->Before that Clear it.60056 element.clear()
        8- zipCode.sendKeys(60018, Keys.ENTER);
        9-Validate the header contains  "New and certified used Lexus RX 350 for sale"
        11-Validate the all titles has Lexus RX 350

        NOTE:If the cookies blocking you, please click Accept All Cookies button
        NOTE:If there is an advertisement, just refresh the page with automation
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://www.cars.com/shopping/");



        WebElement newAndCertified = driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newAndCertified, "new_cpo", "value");


        WebElement chooseLexus = driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(chooseLexus, "lexus", "value");


        WebElement chooseRX350 = driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(chooseRX350, "lexus-rx_350", "value");


        WebElement noMaxPrice = driver.findElement(By.cssSelector("#make-model-max-price"));
        Select selectNoMaxPrice = new Select(noMaxPrice);
        String actualPrice = selectNoMaxPrice.getFirstSelectedOption().getText();
        String expectedPrice = "No max price";
        System.out.println("actualPrice = " + actualPrice);



        Assert.assertEquals(actualPrice, expectedPrice );
        selectNoMaxPrice.selectByIndex(0);



        WebElement distance = driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance, "40", "value");


        WebElement zipCode = driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60016", Keys.ENTER);


        WebElement validateHeader = driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        String actualTitle = validateHeader.getText();
        Assert.assertTrue(actualTitle.contains("New and certified used Lexus RX 350 for sale near"));



        List<WebElement> allMatchingResults = driver.findElements(By.xpath("//a[@class='vehicle-card-link js-gallery-click-link']"));
        for (WebElement lexusRX350 : allMatchingResults) {
            Assert.assertTrue(lexusRX350.getText().contains("Lexus RX 350"));
            System.out.println(lexusRX350.getText());
        }

        driver.quit();

    }
}
