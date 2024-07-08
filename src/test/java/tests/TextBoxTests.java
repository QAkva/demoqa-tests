package tests;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setFullName("John Doe")
                .setEmail("John.Doe@email.com")
                .setCurrentAddress("Baker street 221b")
                .setPermanentAddress("Baker street 221b")
                .submitForm();

        textBoxPage.
                checkName("John Doe")
                .checkEmail("John.Doe@email.com")
                .checkCurrentAddress("Baker street 221b")
                .checkPermanentAddress("Baker street 221b");
    }
}