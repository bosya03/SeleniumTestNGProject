package com.qa.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {

    // We store our WebElements and Methods from LoginPage in this class
    // FRAMEWORK - means is the place where you work on your project


    // Constructor - a way to initialize your instance variable (belongs to class)
    // Every page, we will create constructor

    public BankLoginPage (WebDriver driver) {

        //it will initialize the web elements in this class (ex: use key to start your car)
        PageFactory.initElements(driver, this);

        //DRIVER - It tells the PageFactory which browser and session to use when looking for elements.
        //THIS - It's telling PageFactory: "Initialize the WebElements inside this object
        // (i.e. the current page class)."

    }

    @FindBy (xpath = "//button[@class='btn home']")
    WebElement homeButton;

    @FindBy (tagName = "strong")
    WebElement headerXYZBank;

    @FindBy (xpath = "//button[.='Customer Login']")
    WebElement customerLoginButton;

    @FindBy (xpath = "//button[.='Bank Manager Login']")
    WebElement bankManagerLogin;


    public void checkLoginPageInformation(String expectedBankName) { //validation part

        Assert.assertTrue(homeButton.isDisplayed() && homeButton.isEnabled());
        Assert.assertEquals(headerXYZBank.getText(), expectedBankName);
        Assert.assertTrue(customerLoginButton.isDisplayed() && customerLoginButton.isEnabled());
        Assert.assertTrue(bankManagerLogin.isDisplayed() && bankManagerLogin.isEnabled());

        // do not provide any data inside the method (it's hardcoded way)
        // Assert.assertEquals(headerXYZBank.getText(), "XYZ Bank"); not good

        // provide data in test class
    }

    public void clickLoginBankManager () {
        bankManagerLogin.click();

    }


}
