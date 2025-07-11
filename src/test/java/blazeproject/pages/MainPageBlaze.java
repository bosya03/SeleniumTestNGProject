package blazeproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPageBlaze {

    public MainPageBlaze (WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy (css = "#signin2")
    WebElement goToSignUp;

    @FindBy (xpath = "//a[@id='itemc']")
    List<WebElement> categories;



    public void openSignUpPart () {
        goToSignUp.click();
    }



    public void chooseCategories (String chooseCategory) throws InterruptedException {

        Thread.sleep(2000);

        //This is for choosing category, because I do not want to continue after I choose
        //Otherwise you will get StaleReferenceElement Exception

        for (WebElement category : categories) {
            if (category.getText().contains(chooseCategory)) {
                category.click();
                break;
            }
        }

    }
}
