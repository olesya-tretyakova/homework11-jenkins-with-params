package com.my_company.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateComponent {
    public void selectState(String state) {
        $("#stateCity-wrapper").$(byText("Select State")).scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText(state)).click();
    }
}
