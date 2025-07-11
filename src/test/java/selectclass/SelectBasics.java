package selectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {

    //whenever you see select tag, use select class


    @Test
    public void selectMethods () throws InterruptedException {

        ChromeDriver driver = new ChromeDriver ();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

        WebElement optionsBox=driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select=new Select(optionsBox); //it works on the box that you provided

        //It checks for the "DEFAULT OPTION" ON THE WEBSITE
        String actualDefault=select.getFirstSelectedOption().getText();
        String expectedDefault="Please select an option";
        Assert.assertEquals(actualDefault,expectedDefault);


        select.selectByVisibleText("Option 1"); //it will choose option 1 with visible text
        Thread.sleep(2000);

        select.selectByValue("2"); //it will choose option 2 with Value of value
        Thread.sleep(2000);

        select.selectByIndex(1);//it will choose option 1 with index value

        //It will print out all the options from the drop-down
        List<WebElement> allOptions=select.getOptions();
        List<String> expectedOptions= Arrays.asList("Please select an option","Option 1","Option 2");

        for(int i=0;i<allOptions.size();i++) {
            Assert.assertEquals(allOptions.get(i).getText(), expectedOptions.get(i));
        }
    }

    @Test
    public void selectMethodsPractise () throws InterruptedException {

                            /*
            1-Validate the default value is "UNITED STATES"
            2-Choose Your own country with "VisibleText" Method Thread.sleep to see how it is changing
            3-Choose your favorite country with "value" method Thread.sleep
            4-Choose the country you do not want to visit "index" Thread.sleep
            5-Validate the number of countries is 264
            6-Print out all the countries
            7-driver.quit()
             */

        ChromeDriver driver = new ChromeDriver ();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/erbol/Desktop/codeWiseWebsite.html");


        WebElement validateDefaultCountry = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(validateDefaultCountry);

        String actualDefault = select.getFirstSelectedOption().getText();
        String expectedDefault = "UNITED STATES";
        Assert.assertEquals(actualDefault, expectedDefault);

        select.selectByVisibleText("KYRGYZSTAN ");
        Thread.sleep(2000);

        select.selectByValue("187");
        Thread.sleep(2000);

        select.selectByIndex(3);
        Thread.sleep(2000);


        List<WebElement> numberOfCountries = select.getOptions();
        System.out.println("numberOfCountries = " + numberOfCountries.size());

        int actualNumOfCountries = 264;
        int expectedNumOfCountries = numberOfCountries.size();
        Assert.assertEquals(actualNumOfCountries, expectedNumOfCountries);

        for (WebElement countries : numberOfCountries) {
            System.out.println(countries.getText());
        }

        driver.quit();


    }
}
