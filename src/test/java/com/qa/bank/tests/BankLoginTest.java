package com.qa.bank.tests;

import com.qa.bank.pages.BankLoginPage;
import org.testng.annotations.Test;

public class BankLoginTest extends BankTestBase {

    // interview question
    // where do you use in Automation ?
    // I use here, inheritance

    //In test class, I generally use Validate keyword in test class

    @Test
    public void validateLoginPageInformation () {

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.checkLoginPageInformation("XYZ Bank");


    }
}
