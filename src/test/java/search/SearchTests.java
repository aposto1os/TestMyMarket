package search;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ResultsPage;

import static org.testng.Assert.assertEquals;

public class SearchTests extends BaseTests {

    @Test
    public void searchForDeodorant(){
        ResultsPage resultsPage = homePage.searchFor("dove Αποσμητικό Spray coconut");
        assertEquals(resultsPage.getFirstResultText(),
                "Dove Αποσμητικό Σωμ. Spray Advanced Care Coconut 150ml",
                "incorrect result text.");
    }
}
