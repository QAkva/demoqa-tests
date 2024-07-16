package pages.сomponents;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    private final SelenideElement
            tableTitle = $("#example-modal-sizes-title-lg"),
            tableContents = $(".table-responsive");

    public final String
            modalHeaderText = "Thanks for submitting the form";

    public ResultTableComponent checkTitle (String value){
        tableTitle.shouldHave(text(value));

        return this;
    }

    public ResultTableComponent checkEntry (String value){
        tableContents.shouldHave(text(value));

        return this;
    }

    public ResultTableComponent checkTable (){
        tableContents.shouldNotBe(exist);

        return this;
    }
    
}
