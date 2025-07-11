package testngconcept;

import org.testng.annotations.Test;

public class TestNGIntro {


    @Test (priority = 3, invocationCount = 5) // invocationCount - means it will run this code 5 times
    public void test1() {
        System.out.println("Test 1");
    }

    @Test
    public void test2 () {
        System.out.println("Test 2");
    }

    @Test (priority = 2)
    public void test3 () {
        System.out.println("Test 3");
    }
}
