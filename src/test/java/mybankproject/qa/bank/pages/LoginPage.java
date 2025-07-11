package mybankproject.qa.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[@class='btn home']")
    WebElement homeButton;

    @FindBy (xpath = "//strong[@class='mainHeading']")
    WebElement headerXYZBank;

    @FindBy (xpath = "//button[@ng-click='customer()']")
    WebElement customerLoginButton;

    @FindBy (xpath = "//button[@ng-click='manager()']")
    WebElement bankManagerLoginButton;


    public void validateLoginPage (String expectedBankName) {

        Assert.assertTrue(homeButton.isDisplayed() && homeButton.isEnabled());
        Assert.assertEquals(headerXYZBank.getText(), expectedBankName);
        Assert.assertTrue(customerLoginButton.isDisplayed() && customerLoginButton.isEnabled());
        Assert.assertTrue(bankManagerLoginButton.isDisplayed() && bankManagerLoginButton.isEnabled());

    }

    public void clickBankManagerLogin () {
        bankManagerLoginButton.click();
    }

    public void goToCustomerLogin () {
        customerLoginButton.click();
    }


}
