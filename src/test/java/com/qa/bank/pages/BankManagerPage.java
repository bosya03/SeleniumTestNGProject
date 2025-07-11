package com.qa.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BankManagerPage {

    public BankManagerPage (WebDriver driver) {
       PageFactory.initElements(driver, this);

    }


    @FindBy (xpath = "//button[@ng-click='addCust()']")
    WebElement addCustomerButton;

    @FindBy (xpath = "//input[@ng-model='fName']")
    WebElement firstName;

    @FindBy (xpath = "//input[@ng-model='lName']")
    WebElement lastName;

    @FindBy (xpath = "//input[@ng-model='postCd']")
    WebElement postalCode;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement submitButton;



    public void addCustomerFunctionality (WebDriver driver,
                                         String firstName, String lastName,
                                         String postalCode, String popUpMessageValidation ) throws InterruptedException {

        addCustomerButton.click();

        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);

        Thread.sleep(2000);

        submitButton.click();


        //validate alert
        //Customer added successfully with customer id :9
        //accept alert OK

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(popUpMessageValidation));
        alert.accept();



    }



    @FindBy (xpath = "//button[@ng-class='btnClass2']")
    WebElement openAccountButton;

    @FindBy (xpath = "//select[@id='userSelect']")
    WebElement selectCustomerName;

    @FindBy (xpath = "//select[@id='currency']")
    WebElement selectCurrency;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement submitProcess;

    @FindBy (xpath = "//input[@ng-model='searchCustomer']")
    WebElement searchCustomer;

    @FindBy (xpath = "//button[@ng-class='btnClass3']")
    WebElement goToCustomers;


    public void openAccountFunctionality (WebDriver driver,
                                          String customerName,
                                          String currency,
                                          String popMessageValidation,
                                          String searchName) throws InterruptedException {

        openAccountButton.click(); //opens account

        BrowserUtils.selectBy(selectCustomerName, customerName, "text");
        BrowserUtils.selectBy(this.selectCurrency, currency, "text");

        Thread.sleep(2000); // only for you to see the process

        submitProcess.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(popMessageValidation));
        alert.accept();

        Thread.sleep(2000);
        //

        goToCustomers.click();
        searchCustomer.click();

        this.searchCustomer.sendKeys(searchName);


    }

}
