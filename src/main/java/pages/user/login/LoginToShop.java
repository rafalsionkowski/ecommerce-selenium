package pages.user.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utils.log.Log;

public class LoginToShop extends BasePage {

    private By loginButton = By.xpath("//a[@title='Log in to your customer account']");
    private By emailInput = By.xpath("//input[@id='email']");
    private By passInput = By.xpath("//input[@id='passwd']");
    private By submitButton = By.id("SubmitLogin");
    private By errorMessage = By.xpath("//li[normalize-space()='Authentication failed.']");
    private By sucessIconHome = By.xpath("//i[@class='icon-home']");


    public LoginToShop(WebDriver driver) {

        super(driver);
    }

    public LoginToShop goToLoginPage() {

        click(loginButton);
        return this;
    }

    public LoginToShop setEmail(String emailValue) {

        type(emailValue, emailInput);
        return this;
    }

    public LoginToShop setPass(String passValue) {

        type(passValue, passInput);
        return this;

    }

    public LoginToShop submitForm() {

        click(submitButton);

        return this;

    }

    public boolean checkIfLoginFailed() {
        {
            try {
                if (find(errorMessage).isDisplayed())
                    return false;
                } catch (NoSuchElementException exception) {
                Log.error("Element was not found: " + exception);
            }
        }
        return true;
    }

    public boolean checkIfLoginSucceed() {
        {
            try {
                if (find(sucessIconHome).isDisplayed())
                    return true;
            } catch (NoSuchElementException exception) {
                Log.error("Element was not found: " + exception);
            }
        }
        return false;
    }

}

