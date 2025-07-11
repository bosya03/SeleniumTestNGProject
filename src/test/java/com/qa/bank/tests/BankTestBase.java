package com.qa.bank.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.time.Duration;

public class BankTestBase {

    // TestBase - is a class that we store our "SETUP AUTOMATION" and "TEAR DOWN" - (closing page)

    public WebDriver driver;

    @BeforeMethod // it runs before each @Test annotation
    public void setup () {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.readProperty("bank-url"));
       // driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");


    }

    @AfterMethod // it runs after each @Test annotation
    public void tearDown () {

       // driver.quit();
        //during the development (writing automation) just comment out, in order to see steps

    }


}
