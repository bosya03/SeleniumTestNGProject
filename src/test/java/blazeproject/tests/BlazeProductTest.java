package blazeproject.tests;

import blazeproject.pages.MainPageBlaze;
import blazeproject.pages.ProductPageBlaze;
import org.testng.annotations.Test;

public class BlazeProductTest extends BlazeTestBase {


    @Test(dataProvider= "products", dataProviderClass = BlazeDataProvider.class)
    public void validateProductInfo (String category, String product, String price,
                                     String description, String message) throws InterruptedException {

        //choosing category -> LAPTOPS
        MainPageBlaze mainPageBlaze = new MainPageBlaze(driver);
        mainPageBlaze.chooseCategories(category);

        //choosing product MacBook Air
        ProductPageBlaze productPageBlaze = new ProductPageBlaze(driver);
        productPageBlaze.chooseProduct("MacBook air");

        productPageBlaze.productInformation(driver, product, price, description, message);

    }
}
