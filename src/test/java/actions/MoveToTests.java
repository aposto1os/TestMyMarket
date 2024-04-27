package actions;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.MilkPage;

import static org.testng.Assert.assertEquals;

public class MoveToTests extends BaseTests {

    @Test
    public void moveToMilkPageTest(){
        MilkPage milkPage = homePage.getMilkPage();
        assertEquals(milkPage.getH1Text(), "Γάλα", "incorrect h1 or page.");
    }
}
