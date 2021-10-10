package com.my_company.pages;

import com.codeborne.selenide.SelenideElement;
import com.my_company.pages.components.CalendarComponent;
import com.my_company.pages.components.CityComponent;
import com.my_company.pages.components.StateComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            email = $("#userEmail"),
            sex = $("#genterWrapper"),
            userPhone = $("#userNumber"),
            subject = $("#subjectsInput"),
            hobby = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            submit_btn = $("#submit"),
            titleForm = $(".modal-title");

    public CalendarComponent calendar = new CalendarComponent();
    public StateComponent state = new StateComponent();
    public CityComponent city = new CityComponent();

    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        email.setValue(value);
        return this;
    }

    public RegistrationPage typeAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        sex.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage typePhone(String value) {
        userPhone.setValue(value);
        return this;
    }

    public RegistrationPage fillSubjects(String value) {
        subject.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage selectHobby(String value) {
        hobby.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage submitClick() {
        submit_btn.click();
        return this;
    }

    public RegistrationPage checkTitleValue(String title) {
        titleForm.shouldHave(text(title));
        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}