package pages;

import com.codeborne.selenide.SelenideElement;
import pages.Components.CalendarComponent;
import pages.Components.ResultTableComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarComponentInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyWrapper = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelection = $("#state"),
            citySelection = $("#city"),
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");

        return this;
    }
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String date, String month, String year){
        calendarComponentInput.click();
        calendarComponent.setDate(date, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value){
        hobbyWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String classpath){
        pictureUpload.uploadFromClasspath(classpath);

        return this;
    }

    public RegistrationPage setAddress(String value){
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage selectState(String value){
        stateSelection.click();
        stateSelection.$(byText(value)).click();

        return this;
    }

    public RegistrationPage selectCity(String value){
        citySelection.click();
        citySelection.$(byText(value)).click();

        return this;
    }

    public void submitForm(){
        submitButton.click();
    }

    public RegistrationPage checkTableTitle(String value){
        resultTableComponent.checkTitle(value);

        return this;
    }

    public RegistrationPage checkTableValue(String value){
        resultTableComponent.checkEntry(value);

        return this;
    }

    public RegistrationPage checkTableNotExists(){
        resultTableComponent.checkTable();

        return this;
    }
}

