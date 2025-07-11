package synchronization;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class PractiseWaitsFillOutForm {

    @Test
    public void test1 () throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--host-resolver-rules=MAP *.doubleclick.net 127.0.0.1, MAP *.googlesyndication.com 127.0.0.1");
        //this will block all browser pop ups and some ads

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");

        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
        userEmail.sendKeys("coding2025@gmail.com");

        //explicit wait for gender part
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='gender-radio-1']")));
        WebElement gender = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        gender.click();

        WebElement userNumber = driver.findElement(By.cssSelector("#userNumber"));
        userNumber.sendKeys(faker.phoneNumber().phoneNumber());

        WebElement birthDate = driver.findElement(By.cssSelector("#dateOfBirthInput"));
        birthDate.click();

        WebElement dateOFBirth = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select selectDateOfBirth = new Select(dateOFBirth);
        selectDateOfBirth.selectByValue("8");

        WebElement selectYear = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        BrowserUtils.selectBy(selectYear, "2003", "value");


        WebElement dayOfBirth = driver.findElement(By.xpath("//div[@aria-label='Choose Tuesday, September 23rd, 2003']"));
        dayOfBirth.click();

        WebElement subjectInput = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__input']/input"));
        subjectInput.sendKeys("C");
        Thread.sleep(2000);

        WebElement computerScience = driver.findElement(By.xpath("//div[.='Computer Science']"));
        WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.elementToBeClickable(computerScience));
        computerScience.click();


        WebElement hobby = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        Thread.sleep(2000);
        hobby.click();

        WebElement chooseFile = driver.findElement(By.cssSelector("#uploadPicture"));
        chooseFile.sendKeys("/Users/erbol/Downloads/IMG_1686.HEIC");





    }
}
