package pages.user.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SendContactForm extends BasePage {

    private By contactFormButton = By.xpath("//a[@title='Contact Us']");
    private By subjectDropdow = By.xpath("//select[@id='id_contact']");
    private By emailInput = By.xpath("//input[@id='email']");
    private By messageInput = By.xpath("//textarea[@id='message']");
    private By fileUpload = By.xpath("//input[@id='fileUpload']\n");
    private By sendButton = By.xpath("//span[normalize-space()='Send']");
    private By alertSuccess = By.xpath("//p[@class='alert alert-success']");



    public SendContactForm(WebDriver driver) {

        super(driver);
    }

    public SendContactForm goToContactFormPage() {
        click(contactFormButton);
        return this;
    }


    public SendContactForm selectSubjectFromDropdown() {
        selectLastOptionOfDropdown(subjectDropdow);
        return this;
    }

    public SendContactForm addAttachment () {
        type("/Users/rsionkowski/Desktop/test.txt", fileUpload);
        return this;
    }

    public SendContactForm setEmailAdress (String emialValue) {
        type(emialValue, emailInput);
        return this;
    }

    public SendContactForm setMessage (String messageValue) {
        type(messageValue, messageInput);
        return this;

    }

    public SendContactForm sendContactForm() {
        click(sendButton);
        return this;

    }

    public boolean checkIfContactFormSendSucceed() {
        try {
            return find(alertSuccess).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    }
