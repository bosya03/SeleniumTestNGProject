package DataProviderSauceLab.tests;

import org.testng.annotations.*;

public class TestNGDemo {


    @BeforeClass
    public void beforeClass () {
        System.out.println("this is BEFORE CLASS");
    }

    @BeforeMethod
    public void beforeMethod () {
        System.out.println("this is BEFORE method");
    }

    @Test
    public void loginTest () {
        System.out.println("this is login method");
    }

    @Test (groups = "checkout")
    public void checkoutTest () {
        System.out.println("this is checkout method");
    }

    @Test
    public void searchTest () {
        System.out.println("this is search method");
    }

    @AfterMethod
    public void afterMethod () {
        System.out.println("this is AFTER method");
    }


    @AfterClass
    public void afterClass () {
        System.out.println("this is AFTER CLASS");
    }
}