package UnitTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserName {

    // :white_check_mark: Requirements for a Valid Username
    // Let’s say a valid username must:

    // Be between 5 and 15 characters long
    // Contain only letters, numbers, underscores
    // Start with a letter


    public boolean isValidUsername(String username) {
        if (username == null) return false;
        if (username.length() < 5 || username.length() > 15) return false;
        if (!Character.isLetter(username.charAt(0))) return false;
        return username.matches("[a-zA-Z0-9_]+");
    }


    @Test
    public void test1 () {

        Assert.assertTrue(isValidUsername("Erbol"));

    }

    @Test
    public void test2 () {

        Assert.assertTrue(isValidUsername(null));

    }

    @Test
    public void testChars(){

        Assert.assertFalse(isValidUsername("afhsk()fg"));
        Assert.assertFalse(isValidUsername("helloW@rld"));
        Assert.assertFalse(isValidUsername("^elloW"));
        Assert.assertTrue(isValidUsername("hello_World"));

    }
}
