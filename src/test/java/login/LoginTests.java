package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests {

    @Test
    public void loginWithWrongEmailTest(){
        LoginPage loginPage = homePage.clickAuthenticationLink();
        loginPage.enterEmail("myEmail@yahoo.com");
        loginPage.enterPassword("1234");
        loginPage.submit();
        assertEquals(loginPage.getWrongEmailMessage(),
                "Τα συγκεκριμένα στοιχεία δεν αντιστοιχούν με χρήστη στην βάση μας.",
                "incorrect message");
    }
}
