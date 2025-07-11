package mybankproject.qa.bank.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mybankproject.qa.bank.pages.LoginPage;

public class LoginPageTest extends TestBase {


    @Parameters("title")
    @Test
    public void validateLoginPage (String title) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateLoginPage(title);


      //  loginPage.clickBankManagerLogin(); //opens manager page



    }
}
