package blazeproject.tests;

import org.testng.annotations.DataProvider;

public class BlazeDataProvider {

    //it's a special annotation to run the same test with different set of data
    @DataProvider(name = "products")
    public Object [] [] getProductData () {

        return new Object[][] {

                {"Laptops", "MacBook air", "$700 *includes tax", "shared L3 cache.", "Product added"},
                {"Phones","Samsung galaxy s7","$800 *includes tax","phone packs","Product added"}

        };
    }
}
