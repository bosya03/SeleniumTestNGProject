package testngconcept.grouping;

import org.testng.annotations.Test;

public class CheckoutTests {

    @Test (groups = {"regression", "checkout"})
    public void addItemToCart () {

    }

    @Test (groups = {"regression", "checkout"})
    public void applyCouponCode () {

    }

    @Test (groups = {"smoke", "regression"})
    public void completeCheckout () {

    }
}
