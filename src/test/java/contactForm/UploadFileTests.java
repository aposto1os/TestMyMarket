package contactForm;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContactPage;

import static org.testng.Assert.assertEquals;

public class UploadFileTests extends BaseTests {

    @Test
    public void uploadFileTest(){
        String path = "C:\\Users\\User\\Desktop\\test.txt";
        ContactPage contactPage = homePage.getContactPage();
        contactPage.uploadFile(path);
        assertEquals(contactPage.getUploadedFileName(), "test.txt", "incorrect file name.");
    }
}
