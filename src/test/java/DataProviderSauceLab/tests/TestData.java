package DataProviderSauceLab.tests;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "positiveLogin")
    public Object[][] getPositiveLoginData(){

        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user","secret_sauce"},
                {"performance_glitch_user","secret_sauce"},
                {"error_user","secret_sauce"},
                {"visual_user","secret_sauce"}
        };
    }
}
