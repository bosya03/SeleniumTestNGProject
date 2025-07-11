package blazeproject.tests;

import blazeproject.pages.MainPageBlaze;
import blazeproject.pages.SignUpPageBlaze;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainPageTest extends BlazeTestBase {



    //parameters will read data from XML file
    @Parameters ({"userName", "password", "alertMessage"})
    @Test
    public void signUpFunctionality (String userName, String password, String alertMessage) throws InterruptedException {

        MainPageBlaze mainPageBlaze = new MainPageBlaze(driver);
        mainPageBlaze.openSignUpPart();

        SignUpPageBlaze signUpPage = new SignUpPageBlaze(driver);
        signUpPage.signUpFunctionality(driver, userName, password, alertMessage);

    }

}
