package DataProviderSauceLab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLabLoginPage {

    public SauceLabLoginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#user-name")
    WebElement userName;

    @FindBy (css = "#password")
    WebElement password;

    @FindBy (css = "#login-button")
    WebElement loginButton;

    public void loginFunctionality (String userName, String password) {

        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();


    }


}
