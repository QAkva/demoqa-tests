package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class SubmissionFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest(){
        registrationPage.openPage()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("John.Doe@email.com")
                .setGender("Male")
                .setUserNumber("1234567891")
                .setDateOfBirth("1","January","1900")
                .setSubject("Computer Science")
                .setHobby("Reading")
                .uploadPicture("hqdefault.jpg")
                .setAddress("Baker street 221b")
                .selectState("Uttar Pradesh")
                .selectCity("Agra")
                .submitForm();

        registrationPage.checkTableTitle("Thanks for submitting the form\n");
        registrationPage.checkTableValue("Student Name John Doe")
                        .checkTableValue("Student Email John.Doe@email.com")
                        .checkTableValue("Gender Male")
                        .checkTableValue("Mobile 1234567891")
                        .checkTableValue("Date of Birth 01 January,1900")
                        .checkTableValue("Computer Science")
                        .checkTableValue("Hobbies Reading")
                        .checkTableValue("hqdefault.jpg")
                        .checkTableValue("Baker street 221b")
                        .checkTableValue("State and City Uttar Pradesh Agra");
    }
    @Test
    void submitOnlyMandatoryFieldsTest(){
        registrationPage.openPage()
                .setFirstName("John")
                .setLastName("Doe")
                .setGender("Male")
                .setUserNumber("1234567891")
                .submitForm();

        registrationPage.checkTableTitle("Thanks for submitting the form\n");
        registrationPage.checkTableValue("Student Name John Doe")
                .checkTableValue("Gender Male")
                .checkTableValue("Mobile 1234567891");

    }

    @Test
    void submitEmptyFormTest(){
        registrationPage.openPage()
                .submitForm();
        registrationPage.checkTableNotExists();
    }
}
