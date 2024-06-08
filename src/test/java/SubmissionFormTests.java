import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SubmissionFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }


    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("John.Doe@email.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567891");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1900");
        $(byText("1")).click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("hqdefault.jpg");
        $("#currentAddress").setValue("Baker street 221b");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Agra")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(exactText("Thanks for submitting the form\n"));
        $(".table-responsive").shouldHave(
                Condition.text("Student Name John Doe"),
                Condition.text("Student Email John.Doe@email.com"),
                Condition.text("Gender Male"),
                Condition.text("Mobile 1234567891"),
                Condition.text("Date of Birth 01 January,1900"),
                Condition.text("Computer Science"),
                Condition.text("Hobbies Reading"),
                Condition.text("hqdefault.jpg"),
                Condition.text("Baker street 221b"),
                Condition.text("State and City Uttar Pradesh Agra")
        );
    }
}
