package pages;

import com.codeborne.selenide.SelenideElement;
import pages.сomponents.OutputTextBoxComponent;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private final SelenideElement
            fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit");

    OutputTextBoxComponent outputTextBoxComponent = new OutputTextBoxComponent();

    public TextBoxPage openPage(){
        open("/text-box");

        return this;
    }

    public TextBoxPage setFullName(String value){
        fullNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value){
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value){
        permanentAddressInput.setValue(value);

        return this;
    }

    public void submitForm(){
        submitButton.click();

    }

    public TextBoxPage checkName(String value){
        outputTextBoxComponent.checkFullNameOutput(value);

        return this;
    }

    public TextBoxPage checkEmail(String value){
        outputTextBoxComponent.checkEmailOutput(value);

        return this;
    }

    public TextBoxPage checkCurrentAddress(String value){
        outputTextBoxComponent.checkCurrentAddressOutput(value);

        return this;
    }

    public TextBoxPage checkPermanentAddress(String value){
        outputTextBoxComponent.checkPermanentAddressOutput(value);

        return this;
    }

}
