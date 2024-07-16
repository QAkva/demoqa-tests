package pages.сomponents;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class OutputTextBoxComponent {
    public SelenideElement
            fullNameOutput = $("#output #name"),
            userEmailOutput = $("#output #email"),
            currentAddressOutput = $("#output #currentAddress"),
            permanentAddressOutput = $("#output #permanentAddress");

    public OutputTextBoxComponent checkFullNameOutput(String value) {
        fullNameOutput.shouldHave(text(value));

        return this;
    }

    public OutputTextBoxComponent checkEmailOutput(String value) {
        userEmailOutput.shouldHave(text(value));

        return this;
    }

    public OutputTextBoxComponent checkCurrentAddressOutput(String value) {
        currentAddressOutput.shouldHave(text(value));

        return this;
    }

    public OutputTextBoxComponent checkPermanentAddressOutput(String value) {
        permanentAddressOutput.shouldHave(text(value));

        return this;
    }
}
