package DataProviderSauceLab.tests;

import org.testng.annotations.*;

public class Hooks {

    @BeforeSuite
    public void beforeSuite () {
        System.out.println("this is BEFORE SUITE");
    }


    @BeforeTest
    public void beforeTest () {
        System.out.println("this is BEFORE TEST");
    }






    @AfterTest
    public void afterTest () {
        System.out.println("this is AFTER TEST");
    }

    @AfterSuite
    public void afterSuite () {
        System.out.println("this is AFTER SUITE");
    }
}
