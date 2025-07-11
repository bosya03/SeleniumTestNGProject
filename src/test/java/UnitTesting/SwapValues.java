package UnitTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SwapValues {



    public static int [] swapValues (int [] array) {

        if (array == null) {
            return null;
        }

        int current = array[0]; //4, 7
        array[0] = array[1]; // 7, 4
        array[1] = current;

        return array; // 7, 4

    }

    @Test
    public void test1 () {
        Assert.assertEquals(swapValues(new int[] {100, 5}), new int[] {5, 100});

    }

    @Test
    public void test2 () {
        Assert.assertEquals(swapValues(new int[] {-100, 5}), new int[] {5, -100});

    }

    @Test
    public void test3 () {
        Assert.assertEquals(swapValues(null), null);

    }
}
