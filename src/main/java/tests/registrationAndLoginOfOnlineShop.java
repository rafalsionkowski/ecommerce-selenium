package tests;
import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListener;

@Listeners({TestListener.class })

public class registrationAndLoginOfOnlineShop extends BaseTest {


    @Test (priority = 0, description = "", retryAnalyzer = RetryTest.class)
    public void failLoginToShop () throws InterruptedException {

        loginToShop
                .goToLoginPage()
                .setEmail(randomData.internet().emailAddress())
                .setPass(randomData.internet().password(5,10))
                .submitForm();

        Assert.assertFalse(loginToShop.checkIfLoginSucced());

    }

    @Test (priority = 1, description = "", retryAnalyzer = RetryTest.class)
    public void sentContactFormCorrectly () throws InterruptedException {

        sendContactForm
                .goToContactFormPage()
                .selectSubjectFromDropdown()
                .setEmailAdress("test@test.gmail.com")
                .setMessage("wiadomość testowa")
                .addAttachment()
                .sendContactForm();

        Assert.assertTrue(sendContactForm.checkIfContactFormSendSucceed());

    }

    @Test (priority = 3, description = "", retryAnalyzer = RetryTest.class)
    public void addNewUserAndFirstLogin() throws InterruptedException {

        addNewUser
                .goToLoginPage()
                .checkEmailAdress()
                .fillRegistrationForm()
                .logOut();

        loginToShop
                .goToLoginPage()
                .setEmail(addNewUser.getEmailAdressToLogin())
                .setPass(addNewUser.getPassword())
                .submitForm();
    }

}
