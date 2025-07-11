package supplysyncframework.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supplysyncframework.pages.SupplySyncCompanyPage;
import supplysyncframework.pages.SupplySyncLoginPage;
import utils.ConfigReader;

public class CreateCompanyTest extends SupplySyncTestBase {

    @Parameters({"companyPhoto", "companyName", "companyEmail", "companyAddress", "companyPhoneNumber", "companyCreatedName"})
    @Test
    public void createCompanyTest(String companyPhoto, String companyName, String companyEmail,
                                  String companyAddress, String companyPhoneNumber, String companyCreatedName) {

        SupplySyncLoginPage loginPage = new SupplySyncLoginPage(driver);
        loginPage.loginSuccess(driver);

        SupplySyncCompanyPage supplySyncCompanyPage = new SupplySyncCompanyPage(driver);

        supplySyncCompanyPage.validateCreateCompanyFunctionality(driver, companyPhoto, companyName, companyEmail, companyAddress, companyPhoneNumber);
        supplySyncCompanyPage.isCompanyCreated(driver, companyCreatedName);

    }
}

