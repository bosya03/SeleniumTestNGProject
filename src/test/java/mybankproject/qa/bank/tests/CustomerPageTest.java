package mybankproject.qa.bank.tests;

import org.testng.annotations.Test;
import mybankproject.qa.bank.pages.CustomerPage;
import mybankproject.qa.bank.pages.LoginPage;
import mybankproject.qa.bank.pages.ManagerPage;

public class CustomerPageTest extends TestBase {

    @Test
    public void validateBankTransaction () throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickBankManagerLogin(); // opens manager page

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.addCustomerFunctionality(driver, "Erbol", "Bakt", "99999",
                "Customer added successfully");

        managerPage.openAccountFunctionality(driver, "Erbol Bakt", "Dollar",
                "Account created successfully");

        managerPage.searchCustomerFunctionality(driver, "Erbol");

        managerPage.returnToHomeButton();

        //home assignment starts here
        loginPage.goToCustomerLogin();

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.checkBankTransactionFunctionality(driver,"Erbol Bakt", "Erbol Bakt",
                "500", "Deposit Successful",
                "300");


    }
}
