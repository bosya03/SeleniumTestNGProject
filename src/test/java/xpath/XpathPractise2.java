package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathPractise2 {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

        WebElement appointmentButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        appointmentButton.click();

        WebElement userName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        userName.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();

        Thread.sleep(3000);

        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");

        WebElement hospitalReadmission = driver.findElement(By.xpath("//input[@name='hospital_readmission']"));

        if (hospitalReadmission.isDisplayed()
                && hospitalReadmission.isEnabled()
                && !hospitalReadmission.isSelected()) {
            hospitalReadmission.click();
        }

        WebElement medicaid = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medicaid.click();

        WebElement visitDate = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        visitDate.sendKeys("14/04/2025");


        WebElement commentArea = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        commentArea.sendKeys("I need an urgent appointment please !");

        WebElement bookAppointmentButton = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppointmentButton.click();

        WebElement appointmentConfirmation = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));

        String actualAppConfirm = appointmentConfirmation.getText();
        String expectedAppConfirm = "Appointment Confirmation";
        System.out.println(actualAppConfirm.equals(expectedAppConfirm) ? "True" : "False");

        WebElement facilityValue = driver.findElement(By.xpath("//p[contains(text(),'Hongkong')]"));
        System.out.println("facilityValue = " + facilityValue.getText());

        WebElement applyForHospitalReadmission = driver.findElement(By.xpath("//p[contains(text(),'Yes')]"));
        System.out.println("applyForHospitalReadmission = " + applyForHospitalReadmission.getText());

        WebElement healthcareProgram = driver.findElement(By.xpath("//p[contains(text(),'Medicaid')]"));
        System.out.println("healthcareProgram = " + healthcareProgram.getText());

        WebElement visitingDate = driver.findElement(By.xpath("//p[contains(text(),'14/04/2025')]"));
        System.out.println("visitingDate = " + visitingDate.getText());

        WebElement commentLeft = driver.findElement(By.xpath("//p[contains(text(),'urgent')]"));
        System.out.println("commentLeft = " + commentLeft.getText());

        WebElement goToHomePage = driver.findElement(By.xpath("//a[contains(text(),'Go to Homepage')]"));
        goToHomePage.click();


        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://katalon-demo-cura.herokuapp.com/";
        System.out.println(actualURL.equals(expectedURL) ? " URL IS PASSED " : " URL IS FAILED ");

        driver.quit();


    }
}
