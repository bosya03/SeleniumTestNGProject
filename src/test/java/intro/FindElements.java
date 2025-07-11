package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElements {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///Users/erbol/Desktop/codeWiseWebsite.html");
        //always run each step

        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        //whenever you see find elements, most likely you will use loops and collections
        //if you cannot find directly with child, go up to parent //.//. e.t.c


        for (WebElement box : boxes) {
            if (box.isDisplayed() && box.isEnabled() && !box.isSelected()) {
                box.click();
            }
        }


        //print out how many links

//        driver.get("https://the-internet.herokuapp.com/");
//        List<WebElement> links = driver.findElements(By.xpath("//ul//li//a[@href]"));
//
//        for (WebElement link : links) {
//            System.out.println(link.getText());
//        }
//
//        System.out.println("Number of links -> " + links.size());



        //print only links with length >= 12
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> links = driver.findElements(By.xpath("//ul//li//a[@href]"));

        int counter = 0;
        for (WebElement link : links) {
            if (link.getText().length() >= 12) {
                counter ++;
                System.out.println("Link with length >= 12 are -> " + link.getText());
            }
        }
        System.out.println(counter);





    }
}

