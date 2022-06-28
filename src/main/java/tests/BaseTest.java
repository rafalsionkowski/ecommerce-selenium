package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.AddProductToShopingCart;
import pages.user.contact.SendContactForm;
import pages.user.login.LoginToShop;
import pages.user.register.AddNewUser;
import utils.screenshotfactory.ScreenShotTest;

import java.util.Locale;

;

public class BaseTest {
    protected ChromeDriver driver;
    private final String URL = "http://automationpractice.com/index.php";
    protected String URLDashboardPage = "http://automationpractice.com/index.php";
    protected LoginToShop loginToShop;
    protected SendContactForm sendContactForm;
    protected AddNewUser addNewUser;
    protected Faker randomData;
    protected ScreenShotTest screenShot;
    protected AddProductToShopingCart addProductToShopingCart;


    @BeforeSuite
    public void setUp () throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        loginToShop = new LoginToShop(driver);
        sendContactForm = new SendContactForm(driver);
        addNewUser = new AddNewUser(driver);
        randomData = new Faker(new Locale("pl"));
        screenShot = new ScreenShotTest(driver);
        addProductToShopingCart = new AddProductToShopingCart(driver);
        }

    @AfterClass
    public void gotToDashboard() {
        driver.get(URLDashboardPage);
    }

   @AfterSuite
   public void tearDown () throws Exception {
        driver.quit();
   }
    }

