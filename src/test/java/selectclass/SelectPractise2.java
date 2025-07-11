package selectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectPractise2 {


    @Test
    public void validateOrderTravelTicketWithUtils() throws InterruptedException {

                             /*
            1-Navigate to the website (https://demo.guru99.com/test/newtours/reservation.php)
            2-Select one way trip button
            3-Choose 4 passangers
            4-Validate the depart from is default "Acapulco"
            5-Choose the depart from is Paris
            6-Choose the date August 15th
            7-Choose the arrive in is San Francisco
            8-Choose the date December 15th
            10-Click first class option.
            11-Validate All the options from Airline
            12-Choose the Unified option from airline list
            13-Click Continue
            14-Validate the message from header which should be "After flight finder - No Seats Available" (you can use font_size=4 for element location)

             NOTE:Your test should fail
             NOTE2:You can use any select method value,visibleText,index
             */

        ChromeDriver driver = new ChromeDriver ();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWayTripButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayTripButton.click();


        //BROWSER UTILS USING
        WebElement passCount = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passCount, "4", "value");
        //instead of repeating
//        Select select = new Select(passCount);
//        select.selectByVisibleText("4");


        WebElement fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));

        Select selectPort = new Select(fromPort);
        String actualDepart = selectPort.getFirstSelectedOption().getText();

        String expectedDepart = "Acapulco";
        Assert.assertEquals(actualDepart, expectedDepart);

        selectPort.selectByValue("Paris");
        Thread.sleep(2000);


        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(fromMonth, "8", "value");
        Thread.sleep(2000);

//        Select selectMonth = new Select(fromMonth);
//        selectMonth.selectByValue("8");

        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Thread.sleep(2000);
        BrowserUtils.selectBy(fromDay, "15", "value");


//        Select selectDay = new Select(fromDay);
//        selectDay.selectByValue("15");


        WebElement arrivingIn = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arrivingIn, "San Francisco", "value");

//        Select selectArrivingIn = new Select(arrivingIn);
//        selectArrivingIn.selectByValue("San Francisco");
        Thread.sleep(2000);


        WebElement returningIn = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(returningIn, "12", "value");
//        Select selectReturningIn = new Select(returningIn);
//        selectReturningIn.selectByValue("12");
        Thread.sleep(2000);


        WebElement returningDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(returningDay, "15", "value");

//        Select selectReturnDay = new Select(returningDay);
//        selectReturnDay.selectByValue("15");
        Thread.sleep(2000);

        WebElement firstClassOption = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassOption.click();


        WebElement airlineVariants = driver.findElement(By.xpath("//select[@name='airline']"));
        Select selectAirlines = new Select(airlineVariants);

        List<WebElement> allAirlineOptions = selectAirlines.getOptions();
        List<String> expectedAirlineOptions= Arrays.asList("No Preference", "Blue Skies Airlines"
        ,"Unified Airlines", "Pangea Airlines");

        for (int i = 0; i < allAirlineOptions.size(); i ++) {
            Assert.assertEquals(allAirlineOptions.get(i).getText(), expectedAirlineOptions.get(i));
        }

        selectAirlines.selectByVisibleText("Unified Airlines");
        Thread.sleep(2000);

        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        WebElement validateHeader = driver.findElement(By.xpath("//font[@size='4']"));
        String actualHeader = validateHeader.getText();
        String expectedHeader = "After flight finder - No Seats Avaialble";
        
        Assert.assertEquals(actualHeader, expectedHeader);

        driver.quit();


    }
}
