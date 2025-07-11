package blazeproject.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignUpPageBlaze {


    public SignUpPageBlaze(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy (css = "#sign-username")
    WebElement username;

    @FindBy (css = "#sign-password")
    WebElement password;

    @FindBy (xpath = "//button[.='Sign up']")
    WebElement signUpButton;

    public void signUpFunctionality (WebDriver driver, String userName, String password, String alertMessage) throws InterruptedException {

        this.username.sendKeys(userName);
        this.password.sendKeys(password);

        signUpButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(), alertMessage);
        alert.accept();

    }
}
