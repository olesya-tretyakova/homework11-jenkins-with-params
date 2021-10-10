package com.my_company.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CityComponent {
    public void selectCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }
}
