package mybankproject.qa.bank.tests;

import com.qa.bank.tests.BankTestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mybankproject.qa.bank.pages.LoginPage;
import mybankproject.qa.bank.pages.ManagerPage;

public class ManagerPageTest extends BankTestBase {

    @Parameters({"addFirstName", "addLastName", "addPostCode", "alertMessage1",
    "openName", "openCurrency", "alertMessage2",
    "nameToSearch"})
    @Test
    public void validateAddCustomerFunctionality (String addFirstName, String addLastName, String addPostCode,
                                                  String alertMessage1, String openName, String openCurrency,
                                                  String alertMessage2, String nameToSearch ) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickBankManagerLogin(); // opens manager page

        ManagerPage managerPage = new ManagerPage(driver);

//        managerPage.addCustomerFunctionality(driver, "Bola", "Bak", "60000",
//                "Customer added successfully");
        managerPage.addCustomerFunctionality(driver, addFirstName, addLastName, addPostCode, alertMessage1);

//        managerPage.openAccountFunctionality(driver, "Harry Potter", "Dollar",
//                "Account created successfully");
        managerPage.openAccountFunctionality(driver, openName, openCurrency, alertMessage2);

//        managerPage.searchCustomerFunctionality(driver, "H");
        managerPage.searchCustomerFunctionality(driver, nameToSearch);

        managerPage.returnToHomeButton();

        //home assignment starts here
        loginPage.goToCustomerLogin();



        //        managerPage.openAccountFunctionality(ConfigReader.readProperty("bank_firstName"),
//                ConfigReader.readProperty("bank_lastName"),
//                ConfigReader.readProperty("bank_zipCode"),
//                ConfigReader.readProperty("bank_key"));

    }
}
