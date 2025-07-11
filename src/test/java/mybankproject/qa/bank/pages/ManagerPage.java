package mybankproject.qa.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;


public class ManagerPage extends LoginPage {

    public ManagerPage (WebDriver driver) {
        super(driver); //to reuse homebutton
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[@ng-click='addCust()']")
    WebElement addCustomer;

    @FindBy (xpath = "//input[@ng-model='fName']")
    WebElement firstName;

    @FindBy (xpath = "//input[@ng-model='lName']")
    WebElement lastName;

    @FindBy (xpath = "//input[@ng-model='postCd']")
    WebElement postalCode;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement submitButton;


    //here forgot to put driver WebDriver driver and for alert as well
    public void addCustomerFunctionality (WebDriver driver, String fName, String lName, String postCode,
                                          String expectedAlertMessage) {

        addCustomer.click();
        this.firstName.sendKeys(fName);
        this.lastName.sendKeys(lName);
        this.postalCode.sendKeys(postCode);

        submitButton.click();

        //validate alert
        //Customer added successfully with customer id :9
        //accept alert OK

        //Customer added successfully

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedAlertMessage));
        alert.accept();

    }


    //web element of OpenAccount functionality

    @FindBy (xpath = "//button[@ng-class='btnClass2']")
    WebElement openAccount;

    @FindBy (xpath = "//select[@id='userSelect']")
    WebElement selectCustomerName;

    @FindBy (xpath = "//select[@id='currency']")
    WebElement selectCurrency;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement processButton;

    // After process button, there is ALERT
    // Account created successfully

    public void openAccountFunctionality (WebDriver driver, String custName, String currency,
                                          String expectedAlertMessage) {

        openAccount.click();
        BrowserUtils.selectBy(selectCustomerName, custName, "text");
        BrowserUtils.selectBy(selectCurrency, currency, "value");
        processButton.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedAlertMessage));
        alert.accept();

    }


    @FindBy (xpath = "//button[@ng-class='btnClass3']")
    WebElement goToCustomers;

    @FindBy (xpath = "//input[@ng-model='searchCustomer']")
    WebElement searchCustomer;


    public void searchCustomerFunctionality (WebDriver driver, String nameToSearch) {

        //forgot to validate

        goToCustomers.click();
        this.searchCustomer.sendKeys(nameToSearch);

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

        for (WebElement row : rows) {
            List<WebElement> details = row.findElements(By.tagName("td"));

            if (details.size() >= 4) {
                String firstName = details.get(0).getText();
                String lastName = details.get(1).getText();
                String postCode = details.get(2).getText();
                String accountNumber = details.get(3).getText();

                System.out.println(firstName + " | " + lastName + " | " + postCode + " | " + accountNumber);

            }
            //regular assert is enough, as long as your test annotation is passed !!!
        }
    }

    // I could create this method inside login page, but return home is inside manager page
    public void returnToHomeButton () {
        homeButton.click();

    }
}
