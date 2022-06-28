package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utils.log.Log;

public class AddProductToShopingCart extends BasePage{


    private final By productToAdd = By.xpath("//a[@title='Women']");
    private final By addProductToCart = By.xpath("//li[@class='sfHover']//a[@title='T-shirts'][normalize-space()='T-shirts']");

    public AddProductToShopingCart(WebDriver driver) {
        super(driver);
    }

    public AddProductToShopingCart goToElement() throws InterruptedException {
        moveToElement(productToAdd);
        return this;
    }


}


