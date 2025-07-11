package testngconcept.grouping;

import org.testng.annotations.Test;

public class LoginTests {

    @Test (groups = {"smoke", "regression"})
    public void validLogin () {

    }

    @Test (groups = {"regression", "login"})
    public void invalidLogin () {

    }

    @Test (groups = {"regression", "login"})
    public void forgotPassword () {

    }
}
