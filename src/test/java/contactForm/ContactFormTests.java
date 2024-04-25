package contactForm;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContactPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactFormTests extends BaseTests {

    @Test
    public void fullNameFieldTest(){
        String name = "Apostolos Pantazopoulos";
        ContactPage contactPage = homePage.getContactPage();
        contactPage.setFullNameField(name);
        assertEquals(contactPage.getFullNameField(), name, "incorrect name");
    }

    @Test
    public void dropdownTest(){
        String option = "Saver pass";
        ContactPage contactPage = homePage.getContactPage();
        contactPage.selectFromDropdown(option);
        assertEquals(contactPage.getSelectedOptions().size(), 1, "incorrect number of selected options.");
        assertTrue(contactPage.getSelectedOptions().contains(option), "Option not selected.");
    }
}
