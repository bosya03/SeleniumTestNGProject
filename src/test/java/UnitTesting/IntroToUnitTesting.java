package UnitTesting;


import org.testng.Assert;
import org.testng.annotations.Test;

public class IntroToUnitTesting {


    public static int add (int a, int b) {
        return a + b;
    }


    @Test
    public void test1 () {
        Assert.assertEquals(add(0, 0), 0);

    }

    @Test
    public void test2 () {
        Assert.assertEquals(add(3, 5), 8);

    }

    @Test
    public void test3 () {
        Assert.assertEquals(add(-5, -4), -9);

    }
}
