package supplysyncframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SupplySyncCompanyPage {

    public SupplySyncCompanyPage (WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "upload-photo")
    public WebElement uploadPhotoButton;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement companyName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement address;

    @FindBy(xpath = "//input[@placeholder='+1 ___ ___ ____ *']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement createButton;

    @FindBy(xpath = "//div[contains(@class,'sc-iukxot')]/parent::div")
    public List<WebElement> companyCards;

    @FindBy(xpath = "//span[@class='sc-ctqQKy jusjEk MuiButton-startIcon MuiButton-iconSizeMedium']/..")
    public WebElement createCompanyButton;

    public void validateCreateCompanyFunctionality (WebDriver driver, String companyPhoto,
                                                    String companyName, String companyEmail,
                                                    String companyAddress, String companyPhoneNumber) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(createCompanyButton)).click();


        Assert.assertTrue(uploadPhotoButton.isEnabled());
        this.uploadPhotoButton.sendKeys(companyPhoto);

        this.companyName.sendKeys(companyName);
        this.email.sendKeys(companyEmail);
        this.address.sendKeys(companyAddress);

        phoneNumber.click();
        this.phoneNumber.sendKeys(companyPhoneNumber);

        createButton.click();


    }

    public boolean isCompanyCreated (WebDriver driver, String createdCompanyName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class,'sc-iukxot')]/parent::div")));

        for (WebElement card : companyCards) {
            String text = card.getText().trim();
            System.out.println("Card text: " + text);
            if (text.contains(createdCompanyName)) {
                return true;
            }
        }
        return false;
    }
}
