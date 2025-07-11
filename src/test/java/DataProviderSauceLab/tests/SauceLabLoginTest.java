package DataProviderSauceLab.tests;

import DataProviderSauceLab.pages.SauceLabLoginPage;
import org.testng.annotations.Test;

public class SauceLabLoginTest extends TestBaseSauceLab {


    @Test (dataProvider = "positiveLogin", dataProviderClass = TestData.class)
    public void validateLoginFunctionality2 (String userName1, String password2) {

        SauceLabLoginPage sauceLabLoginPage = new SauceLabLoginPage(driver);
        sauceLabLoginPage.loginFunctionality(userName1, password2);

    }
}
