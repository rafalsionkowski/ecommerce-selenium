package pages.shoping.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AddProductToShopingCart extends BasePage{


    private final By productToAdd = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");
    private final By addToCartButton = By.xpath("//span[contains(text(),'Add to cart')]");
    private final By proceedToCheckoutButton = By.xpath("//span[normalize-space()='Proceed to checkout']");
    private final By totalPriceText = By.xpath("//span[@id='total_price']");
    private final By cartButton = By.xpath("//b[normalize-space()='Cart']");

    public AddProductToShopingCart(WebDriver driver) {
        super(driver);
    }

    public AddProductToShopingCart addProductToCart() throws InterruptedException {
        moveToElement(productToAdd);
        Thread.sleep(1000);
        click(addToCartButton);
        waitForElement(proceedToCheckoutButton);
        click(proceedToCheckoutButton);
        String totalPrice = find(totalPriceText).getText();
        System.out.println(totalPrice);
        return this;
    }

    public void getCartTotalPrice() {
        String totalPrice = find(totalPriceText).getText();
    }


}



