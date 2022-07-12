package pages;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class BasePage {


    protected WebDriver driver;
    protected Faker randomData = new Faker(new Locale("pl"));



    public BasePage (WebDriver driver) {

        this.driver = driver;

    }

    protected WebElement find (By locator) {

        return driver.findElement(locator);
    }


    protected void type (String text, By locator) {

        find(locator).sendKeys(text);
    }

    protected void click (By locator) {

        find(locator).click();
    }


    protected void selectLastOptionOfDropdown (By locator) {

        Select dropdown = new Select(driver.findElement(locator));

        //Get all options
        List<WebElement> dd = dropdown.getOptions();

        // Loop to print one by one
       // for (int j = 0; j < dd.size(); j++) {
            //System.out.println(dd.get(j).getText());
           dropdown.selectByVisibleText(dd.get(dd.size()-1).getText());

        }

        protected void moveToElement (By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).build().perform();

        }


    protected void waitForElement (By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));

    }
}