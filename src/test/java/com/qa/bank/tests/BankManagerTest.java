package com.qa.bank.tests;

import com.qa.bank.pages.BankLoginPage;
import com.qa.bank.pages.BankManagerPage;
import org.testng.annotations.Test;

public class BankManagerTest extends BankTestBase {

    @Test
    public void validateAddCustomerFunctionality () throws InterruptedException {

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickLoginBankManager(); // we logged into Bank Manager part

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Bosya",
                "Bak", "15106",
                "Customer added successfully");


    }

    @Test
    public void validateOpenAccountFunctionality () throws InterruptedException {

        BankLoginPage bankLoginPage = new BankLoginPage(driver); //driver for initialization
        bankLoginPage.clickLoginBankManager();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Bosya",
                "Bak", "15106",
                "Customer added successfully");

        bankManagerPage.openAccountFunctionality(driver, "Harry Potter",
                "Dollar", "Account created successfully",
                "Harry Potter");


    }

    //home assignment part starts here
    //better to start from scratch, create a new package
//    @Test
//    public void homeAssignment () throws InterruptedException {
//
//        BankLoginPage bankLoginPage = new BankLoginPage(driver);
//        bankLoginPage.clickLoginBankManager();
//
//        BankManagerPage bankManagerPage = new BankManagerPage(driver);
//        bankManagerPage.addCustomerFunctionality(driver, "Bosya",
//                "Bak", "15106",
//                "Customer added successfully");
//
//        bankManagerPage.openAccountFunctionality(driver, "Harry Potter",
//                "Dollar", "Account created successfully",
//                "Harry Potter");




    }

