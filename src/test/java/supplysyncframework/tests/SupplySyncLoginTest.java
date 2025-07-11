package supplysyncframework.tests;

import org.testng.annotations.Test;
import supplysyncframework.pages.SupplySyncLoginPage;

public class SupplySyncLoginTest extends SupplySyncTestBase {


    @Test (priority = 1, groups = {"loginSuccess"})
    public void loginSuccessFunctionality ()  {

        SupplySyncLoginPage supplySyncLoginPage = new SupplySyncLoginPage(driver);
        supplySyncLoginPage.loginSuccess(driver);

    }


    @Test (priority = 2, groups = {"loginFail"})
    public void loginFailedFunctionality () {

        SupplySyncLoginPage supplySyncLoginPage = new SupplySyncLoginPage(driver);
        supplySyncLoginPage.loginFail(driver);

    }
}
