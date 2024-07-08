package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;


import static com.codeborne.selenide.Selenide.*;

public class NavigationBarTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void hoverTest(){
        open("");
        $(byTagAndText("button", "Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $(byText("The AI-powered")).shouldBe(visible);
        }

    }