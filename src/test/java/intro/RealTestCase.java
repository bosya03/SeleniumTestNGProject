package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTestCase {
    public static void main(String[] args) throws InterruptedException {

        //  Test Case - Open Godaddy.com and validate it's Page title and the url.
        //  Steps to Automate:
        //  1. Launch browser of your choice say., Firefox, chrome etc.
        //  2. Open this URL - https://www.godaddy.com/ and Maximize
        //  3. Get Title of page and validate it.(if conditions) expected title -->take it from website practice
        //  3. Get URL of current page and validate it.          expected url from website
        //  4. Close browser.



        // before automate something, first always do manual testing,
        // play around and check everything

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.thespruceeats.com/");

        String spruceActualTitle = driver.getTitle();
        String spruceExpectedTitle = "The Spruce Eats - Make Your Best Meal";

        if (spruceActualTitle.equals(spruceExpectedTitle)) {
            System.out.println("Title is passed");
        } else {
            System.out.println("Title is failed !!!");
        }

        String spruceActualURL = driver.getCurrentUrl();
        String spruceExpectedURL = "https://www.thespruceeats.com/";

        System.out.println(spruceActualURL.equals(spruceExpectedURL) ? "URL PASSED" : "URL FAILED");

        Thread.sleep(2000);
        driver.close();

    }
}
