package testngconcept.grouping;

import org.testng.annotations.Test;

public class SearchTests {

    @Test (groups = {"smoke", "regression"})
    public void searchByKeyword () {

    }

    @Test (groups = "regression")
    public void searchByFilter () {

    }
}
