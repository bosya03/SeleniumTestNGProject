package mybankproject.qa.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BrowserUtils;

import java.time.Duration;

public class CustomerPage {

    public CustomerPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//select[@id='userSelect']")
    WebElement selectYourName; //Bola Bak

    @FindBy (xpath = "//button[.='Login']")
    WebElement loginButton;

    @FindBy (xpath = "//strong/span")
    WebElement validateName;

    @FindBy (xpath = "//button[@ng-class='btnClass2']")
    WebElement depositButton;

    @FindBy (xpath = "//input[@ng-model='amount']")
    WebElement amountToDeposit;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement submitDeposit;

    @FindBy (xpath = "//span[.='Deposit Successful']")
    WebElement depositSuccessful;

    @FindBy (xpath = "//button[@ng-click='withdrawl()']")
    WebElement withdrawButton;

    @FindBy (xpath = "//input[@ng-model='amount']")
    WebElement amountToWithdraw;

    @FindBy (xpath = "//button[.='Withdraw']")
    WebElement submitWithdraw;

    @FindBy (xpath = "//span[.='Transaction successful']")
    WebElement transactionSuccessful;

    @FindBy (xpath = "//strong[.='200']")
    WebElement balanceElement;

    @FindBy (xpath = "//button[@ng-click='transactions()']")
    WebElement goToTransactions;

    @FindBy(xpath = "//tr[@id='anchor0']//td[@class='ng-binding'][2]")
    WebElement credit;

    @FindBy(xpath = "//tr[@id='anchor1']//td[@class='ng-binding'][2]")
    WebElement debit;


    public void checkBankTransactionFunctionality (WebDriver driver, String nameToSelect,
                                                   String nameToValidate,
                                                   String depositAmount,
                                                   String depositSuccessfulMessage,
                                                   String withdrawAmount) throws InterruptedException {

        BrowserUtils.selectBy(selectYourName, nameToSelect, "text");
        loginButton.click();

        Assert.assertTrue(validateName.isDisplayed() &&
                validateName.getText().contains(nameToValidate));


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(depositButton));
        depositButton.click();

        this.amountToDeposit.sendKeys(depositAmount);

        submitDeposit.click();

        Assert.assertTrue(this.depositSuccessful.isDisplayed() &&
                this.depositSuccessful.getText().contains(depositSuccessfulMessage));

//        Assert.assertEquals(actualColor.equals(depositSuccessful.getCssValue(colorPropertyName)), expectedColor);

        withdrawButton.click();

        Thread.sleep(5000);

        this.amountToWithdraw.sendKeys(withdrawAmount);

        Thread.sleep(5000);
        submitWithdraw.click();

        Assert.assertTrue(transactionSuccessful.isDisplayed() &&
                transactionSuccessful.getText().contains("Transaction successful"));

        Thread.sleep(2000);

        String balanceText = balanceElement.getText();
        int actualBalance = Integer.parseInt(balanceText);

        goToTransactions.click();

        Thread.sleep(2000);

        int depAmount = Integer.parseInt(debit.getText());
        int withDrAmount = Integer.parseInt(credit.getText());

        int expectedBalance = depAmount - withDrAmount;

        Assert.assertEquals(actualBalance, expectedBalance);




        //my mistakes in transactions part


//        String currentBalance = balanceElement.getText();
//        int balance = Integer.parseInt(currentBalance);

        // Unboxing - when we convert object into primitive data type

//        goToTransactions.click();


//        String deposited500 = deposit500.getText();
//       // int dep500 = Integer.parseInt(deposited500);
//
//        String withdrawAmount300 = withdraw300.getText();
//       // int withDr300 = Integer.parseInt(withdrawAmount300);


    }
}
