package xpath;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathPractise {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://formy-project.herokuapp.com/form");


        Faker faker = new Faker();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement jobTitle = driver.findElement(By.xpath("//input[@id='job-title']"));
        jobTitle.sendKeys(faker.job().position());

        WebElement educationLevel = driver.findElement(By.xpath("//input[@id='radio-button-2']"));
        educationLevel.click();

        WebElement sex = driver.findElement(By.xpath("//input[@id='checkbox-3']"));

        if (sex.isDisplayed() && sex.isEnabled() && !sex.isSelected()) {
            sex.click();
        } else {
            System.out.println("ERROR");
        }


        WebElement yearsOfExperience = driver.findElement(By.xpath("//select[@id='select-menu']"));
        yearsOfExperience.sendKeys("10+");


        WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
        date.sendKeys("09/23/2003");

        WebElement submitButton = driver.findElement(By.xpath("//a[@role='button']"));
        Thread.sleep(3000);

        submitButton.click();

        //validation
        WebElement thanksForSubmitting = driver.findElement(By.xpath("//h1[contains(text(),'Thanks')]"));

        String actualText = thanksForSubmitting.getText();
        String expectedText = "Thanks for submitting your form";
        System.out.println(actualText.equals(expectedText) ? " Text is passed " : " Text is failed ");

        //validation
        WebElement formWasSubmitted = driver.findElement(By.xpath("//div[contains(text(),' successfully ')]"));
        String actualForm = formWasSubmitted.getText();
        String expectedForm = "The form was successfully submitted!";
        System.out.println(actualForm.equals(expectedForm) ? " Form is passed " : " Form is failed ");



        //contains more safer (secure)
        // .= also good, but if there are spaces, it cannot be matched
        // but we can add that space to inspect, but in future,
        // developer can remove those spaces
        // that's why using contains method more reliable, safer, better (secure)

        driver.quit();

    }
}
