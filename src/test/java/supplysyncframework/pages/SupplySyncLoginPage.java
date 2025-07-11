package supplysyncframework.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ConfigReader;

import java.time.Duration;

public class SupplySyncLoginPage {

    public SupplySyncLoginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//input[@name='email']")
    WebElement email;

    @FindBy (id = "password")
    WebElement password;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement signInButton;

    @FindBy (xpath = "//p[.='Incorrect login and/or password.']")
    WebElement actualErrorMessage;

    public void loginSuccess (WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(email));

        email.sendKeys(ConfigReader.readProperty("emailAdmin"));
        password.sendKeys(ConfigReader.readProperty("passwordAdmin"));
        signInButton.click();

        wait.until(ExpectedConditions.urlContains(ConfigReader.readProperty("expectedURL")));
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.readProperty("expectedURL"));
    }


    public void loginFail (WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(email));

        Faker faker = new Faker();

        String randomEmail = faker.internet().emailAddress();
        String randomPassword = faker.internet().password();

        this.email.clear();
        this.email.sendKeys(randomEmail);
        this.password.sendKeys(randomPassword);

        signInButton.click();

        wait.until(ExpectedConditions.visibilityOf(actualErrorMessage));

        String actualErrorText = actualErrorMessage.getText();
        String expectedErrorMessage = "Incorrect login and/or password.";

        Assert.assertEquals(actualErrorText, expectedErrorMessage);

        Assert.assertNotEquals(driver.getCurrentUrl(), ConfigReader.readProperty("expectedURL"));


    }
}
