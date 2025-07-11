package testngconcept;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersLogic {


    //RUN THIS CODE INSIDE XML FILE

    @Parameters("firstName")
    @Test
    public void person (String name) {
        System.out.println(name);
    }


    @Parameters ({"brand", "color", "zipcode"})
    @Test
    public void order (String brand, String color, String zipcode) {
        System.out.println(brand + color + zipcode);

    }
}
