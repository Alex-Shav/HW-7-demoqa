package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationRfModal;

public class RegistrationTest extends RfTestBase {

    public RegistrationPage registrationPage = new RegistrationPage();
    public RegistrationRfModal registrationResultModal = new RegistrationRfModal();

    @Test
    void fillFormTest() {
        String firstName = "Alex",
                lastName = "Shav",
                email = "AlexShav@mmail.com",
                gender = "Male",
                userTelephoneNumber = "8029112233",
                dayOfBirth = "20",
                monthOfBirth = "March",
                yearOfBirth = "1986",
                fileName = "pic.png",
                address = "Minsk",
                state = "Uttar Pradesh",
                city = "Lucknow";
        String[] subjects = new String[]{"Maths", "Computer Science"};
        String[] hobbies = new String[]{"Sports", "Music"};

        registrationPage.openPage()
                .removeFooter()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserTelephoneNumber(userTelephoneNumber)
                .setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(fileName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        registrationResultModal.verifyModalAppears()
                .verifyResult("Student Name", firstName + ' ' + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userTelephoneNumber)
                .verifyResult("Date of Birth", dayOfBirth + ' ' + monthOfBirth + ',' + yearOfBirth)
                .verifyResult("Subjects", subjects[0] + ", " + subjects[1])
                .verifyResult("Hobbies", hobbies[0] + ", " + hobbies[1])
                .verifyResult("Picture", fileName)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + ' ' + city);
    }
}