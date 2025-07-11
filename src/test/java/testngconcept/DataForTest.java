package testngconcept;

import org.testng.annotations.DataProvider;

public class DataForTest {


    @DataProvider(name = "pairs")
    public Object[][] getData(){

        return new Object[][]{
                {"Erbol", "Kylie"},
                {"Erbol","Megan"},
                {"Erbol","Moon"},
                {"Erbol","Sun"}
        };
    }
}
