package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.сomponents.ResultTableComponent;
import utils.TestData;

public class SubmissionFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent modalWindow = new ResultTableComponent();
    TestData testData = new TestData();
    @Test
    void fillFormTest(){
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.number)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .uploadPicture(testData.uploadFile)
                .setAddress(testData.address)
                .selectState(testData.state)
                .selectCity(testData.city)
                .submitForm();

        modalWindow
                .checkTitle(modalWindow.modalHeaderText)
                .checkEntry(testData.firstName + " " + testData.lastName)
                .checkEntry(testData.email)
                .checkEntry(testData.gender)
                .checkEntry(testData.number)
                .checkEntry(testData.day + " " + testData.month + "," + testData.year)
                .checkEntry(testData.subject)
                .checkEntry(testData.hobby)
                .checkEntry(testData.uploadFile)
                .checkEntry(testData.address)
                .checkEntry(testData.state + " " + testData.city);
    }
    @Test
    void submitOnlyMandatoryFieldsTest(){
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.number)
                .submitForm();

        modalWindow
                .checkTitle(modalWindow.modalHeaderText)
                .checkEntry(testData.firstName + " " + testData.lastName)
                .checkEntry(testData.gender)
                .checkEntry(testData.number);

    }

    @Test
    void submitEmptyFormTest(){
        registrationPage.openPage()
                .submitForm();
        modalWindow.checkTable();
    }
}
