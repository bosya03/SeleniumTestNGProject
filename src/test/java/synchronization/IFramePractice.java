package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class IFramePractice {

    @Test
    public void iframeHomeAssignment () {

                /*
        IFRAME PRACTICE HOMEWORK
        1. go to https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box
        2. retrieve and print "New Browser Tab" text
        3. click on "Open Seprate New Window"
        4. retrieve and print "Open New Seprate Window" text
        5. click on "Open Frameset Window"
        6. retrieve and print "Open Frameset Window" text
        7. click on "Multiple Windows"
        8. retrieve and print "Open Frameset Window" text
        9. Open multiple pages
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box");

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult1.html']"));
        driver.switchTo().frame(iframe);

        WebElement newBrowserTab = driver.findElement(By.xpath("//a[contains(text(), 'New Browser Tab')]"));
        System.out.println(newBrowserTab.getText());

        driver.switchTo().parentFrame();



//        WebElement textInsideIframe = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult1.html']"));
//        driver.switchTo().frame(textInsideIframe);
//
//        WebElement getTextNewBrowserTab = driver.findElement(By.xpath("//a[contains(text(), 'New Browser Tab')]"));
//        System.out.println(getTextNewBrowserTab.getText());
//
//        driver.switchTo().parentFrame();

        WebElement iframeOpenSeprate = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult2.html']"));
        driver.switchTo().frame(iframeOpenSeprate);

        WebElement getTextOpenSeprate = driver.findElement(By.xpath("//a[contains(text(), 'Open New Seprate Window')]"));
        System.out.println(getTextOpenSeprate.getText());

        driver.switchTo().defaultContent();


        WebElement iframeFrameSet = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult3.html']"));
        driver.switchTo().frame(iframeFrameSet);

        WebElement getTextFrameSet = driver.findElement(By.xpath("//a[contains(text(), 'Open Frameset Window')]"));
        System.out.println(getTextFrameSet.getText());

        driver.switchTo().defaultContent();


        WebElement iframeMultiplePages = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult4.html']"));
        driver.switchTo().frame(iframeMultiplePages);

        WebElement getTextMultiplePages = driver.findElement(By.xpath("//a[contains(text(), 'Open multiple pages')]"));
        System.out.println(getTextMultiplePages.getText());

        driver.switchTo().defaultContent();



        //iframe[@src='frames-windows/defult4.html']
        //a[contains(text(), 'Open multiple pages')]


    }
}
