package com.my_company.tests;

import com.github.javafaker.Faker;
import com.my_company.pages.RegistrationPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("owner")
public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            currentAddress = faker.address().fullAddress(),
            gender = faker.demographic().sex(),
            phone = faker.phoneNumber().subscriberNumber(10),
            day = "3",
            month = "July",
            year = "1962",
            state = "Rajasthan",
            city = "Jaiselmer",
            subject = "Math",
            hobby = "Sports",
            fileName = "photo.jpg",
            titleFillForm = "Thanks for submitting the form";

    @Test
    void fillFormTest() {
        registrationPage.openPage();

        registrationPage
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .selectGender(gender)
                .typePhone(phone)
                .calendar.setDate(day, month, year);
        registrationPage
                .fillSubjects(subject)
                .selectHobby(hobby)
                .uploadPicture(fileName)
                .typeAddress(currentAddress)
                .state.selectState(state);
        registrationPage.city.selectCity(city);
        registrationPage.submitClick();

        registrationPage
                .checkTitleValue(titleFillForm)
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", gender)
                .checkResultsValue("Mobile", phone)
                .checkResultsValue("Date of Birth", day + " " + month + "," + year)
                .checkResultsValue("Subjects", subject)
                .checkResultsValue("Hobbies", hobby)
                .checkResultsValue("Picture", fileName)
                .checkResultsValue("Address", currentAddress)
                .checkResultsValue("State and City", state + " " + city);

    }
}
