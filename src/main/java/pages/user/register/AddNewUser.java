package pages.user.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.user.UserDbManager;
import utils.log.Log;

import java.sql.SQLException;

public class AddNewUser extends BasePage {

    private By loginButton = By.xpath("//a[@title='Log in to your customer account']");
    private By signOutButton = By.xpath("//a[@title='Log me out']");
    private By emailAdressInput = By.xpath("//input[@id='email_create']");
    private By createAccountButton = By.xpath("//span[normalize-space()='Create an account']");

    private By genderRadio = By.cssSelector("#id_gender1");
    private By firstNameInput = By.xpath("//input[@id='customer_firstname']");
    private By lastNameInput = By.xpath("//input[@id='customer_lastname']");
    private By passwordInput = By.xpath("//input[@id='passwd']\n");
    private By daysDropdown = By.xpath("//select[@id='days']\n");
    private By monthsDropdown = By.xpath("    //select[@id='months']\n");
    private By yearsDropdown = By.xpath("//select[@id='years']");
    private By firstNameAdressInput = By.xpath("//input[@id='firstname']\n");
    private By lastnameAdressInput = By.xpath("//input[@id='lastname']\n");
    private By adressFirstLineInput = By.xpath("//input[@id='address1']\n");
    private By cityInput = By.xpath("//input[@id='city']");
    private By stateDropdown = By.xpath("//select[@id='id_state']");
    private By postCodeInput = By.cssSelector("#postcode");
    private By countryDropdown = By.xpath("//select[@id='id_country']");
    private By mobilePhoneInput = By.xpath("//input[@id='phone_mobile']\n");
    private By aliasInput = By.xpath("//input[@id='alias']\n");


    private By registerButton = By.xpath("//span[normalize-space()='Register']\n");

    public String getEmailAdressToLogin() {
        return emailAdressToLogin;
    }

    public String getPassword() {
        return password;
    }

    private final String emailAdressToLogin = randomData.internet().emailAddress();


    private final String password = randomData.internet().password(5,10);


    public AddNewUser(WebDriver driver) {

        super(driver);
    }

    public AddNewUser generateCredentials() {

        return this;
    }


    public AddNewUser goToLoginPage() {
        click(loginButton);
        return this;
    }

    public AddNewUser checkEmailAdress() {
        type(emailAdressToLogin, emailAdressInput);
        click(createAccountButton);
        Log.info("email adress used to registration: " + emailAdressToLogin );
        return this;
    }

    public AddNewUser fillRegistrationForm() throws SQLException {
        waitForElement(genderRadio);
        click(genderRadio);
        type(randomData.name().firstName(), firstNameInput);
        type(randomData.name().lastName(), lastNameInput);
        type(password, passwordInput);
        Log.info("Password used to registration: " + password);
        selectLastOptionOfDropdown(daysDropdown);
        selectLastOptionOfDropdown(monthsDropdown);
        selectLastOptionOfDropdown(yearsDropdown);
        type(randomData.address().streetAddress(), adressFirstLineInput);
        type(randomData.address().cityName(), cityInput);
        selectLastOptionOfDropdown(stateDropdown);
        waitForElement(postCodeInput);
        type(randomData.address().zipCode().replace("-","" ), postCodeInput);
        selectLastOptionOfDropdown(countryDropdown);
        type(randomData.phoneNumber().cellPhone(), mobilePhoneInput);
        click(registerButton);

        try {
            UserDbManager userDbManager = new UserDbManager();
            userDbManager.addNewUserToDb(emailAdressToLogin, password);
            Log.info("New user add to DB");
        } catch (SQLException e) {
            Log.error("Can not add User to DB" + e);
        }

        return this;
    }


    public AddNewUser logOut() {
        click(signOutButton);
        return this;
    }

}
