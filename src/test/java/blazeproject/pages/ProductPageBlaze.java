package blazeproject.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductPageBlaze {

    public ProductPageBlaze (WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy (css = ".hrefch")
    List<WebElement> products;

    @FindBy (tagName = "h2")
    WebElement header;

    @FindBy (tagName = "h3")
    WebElement price;

    @FindBy (css = "#myTabContent")
    WebElement description;

    @FindBy (linkText = "Add to cart")
    WebElement addToCartButton;


    public void productInformation (WebDriver driver, String header, String price, String description, String message) throws InterruptedException {

        Assert.assertEquals(this.header.getText(), header);
        Assert.assertEquals(this.price.getText(), price);
        Assert.assertTrue(this.description.getText().contains(description));

        Assert.assertTrue(addToCartButton.isDisplayed() && addToCartButton.isEnabled());
        addToCartButton.click();

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), message);
        alert.accept();

        //Product added -> alert message
    }


    public void chooseProduct (String chooseProduct) throws InterruptedException {

        Thread.sleep(2000);

        for (WebElement product : products) {
            if (product.getText().contains(chooseProduct)) {
                product.click();
                break;
            }
        }

    }
}
