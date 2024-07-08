package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;


public class SoftAssertionsTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void pageHasJUnit5Test(){
        open("selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(text("Soft assertions"));
        $(byText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }"""));
    }
}
