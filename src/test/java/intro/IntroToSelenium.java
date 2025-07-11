package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntroToSelenium {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver(); //polymorphism
        //create an object from WebDriver or ChromeDriver
        // web driver connects my laptop to website

        //make my window maximize
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        //actual comes from website

        String actualTitle = driver.getTitle(); // to make sure we are on the correct page
        System.out.println(actualTitle);

        String expectedTitle = "Amazon.com. Spend less. Smile more."; //it comes from you (story)

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title is passed");

        } else {
            System.out.println("Title is failed !");
        }


        //another navigation

        driver.get("https://www.facebook.com/");

        String facebookActualTitle = driver.getTitle();
        System.out.println(facebookActualTitle);

        String expectedTitleFacebook = "Facebook - log in or sign up";

        if (facebookActualTitle.equals(expectedTitleFacebook)) {
            System.out.println("Facebook Title is passed");
        } else {
            System.out.println("Facebook Title is failed !");
        }

        //dom - html structure



        //validate URL

        String facebookActualURL = driver.getCurrentUrl();
        //to make sure we are on the correct page

        String facebookExpectedURL = "https://www.facebook.com/";

        System.out.println(facebookActualURL.equals(facebookExpectedURL) ? "URL PASSED" : "URL FAILED");

        //driver.close(); //it closes the browser
        //we must use it at the end of the code




    }
}
