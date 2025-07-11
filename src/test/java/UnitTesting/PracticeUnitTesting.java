package UnitTesting;

import org.testng.annotations.Test;

public class PracticeUnitTesting {

    public static void main(String[] args) {
        System.out.println(replace("apple"));
        System.out.println(replace("Apple"));
        System.out.println(replace("ap231p31231p3le"));
        System.out.println(replace(null));
       // System.out.println("");
    }

    public static String replace (String str) {

        if (str == null) {
            return null;
        }

        return str.replace('A', '*').replace('a', '*');

    }


    @Test
    public void test1 () {





    }
}
