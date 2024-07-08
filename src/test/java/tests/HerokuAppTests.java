package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HerokuAppTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browserSize = "1920x1080";
    }
    @AfterEach
    void afterEach(){
        closeWebDriver();
    }

    @Test
    void withActionsTest(){
        open("drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
        $("#column-a").$(byText("B")).should(exist);
        $("#column-b").$(byText("A")).should(exist);
    }

    @Test
    void withoutActionsTest(){
        open("drag_and_drop");
        $("#column-b").dragAndDrop(to("#column-a"));
        $("#column-a").$(byText("B")).should(exist);
        $("#column-b").$(byText("A")).should(exist);
    }
}
