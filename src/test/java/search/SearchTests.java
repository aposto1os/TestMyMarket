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

    @Test
    public void searchForShampoo(){
        ResultsPage resultsPage = homePage.searchFor("wash & go classic 650");
        assertEquals(resultsPage.getFirstResultText(),
                "Wash & Go 2in1 Σαμπουάν Classic 650 ml",
                "incorrect result text.");
    }

    @Test
    public void searchForCheese(){
        ResultsPage resultsPage = homePage.searchFor("nounou gouda φραντζόλα");
        assertEquals(resultsPage.getFirstResultText(),
                "ΝΟΥΝΟΥ Τυρί Gouda Ολλανδίας Φραντζόλα Τιμή Κιλού",
                "incorrect result text.");
    }
}
