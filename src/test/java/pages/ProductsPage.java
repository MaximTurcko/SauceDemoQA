package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final By TITLE = By.cssSelector("[data-test = title]");
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private static final String ADD_REMOVE_TO_CART_BUTTON = "//*[text() = '%s']/ancestor::div" +
            "[@class = 'inventory_item']//button";

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void addProductToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_REMOVE_TO_CART_BUTTON, product))).click();
    }

    public void removeProductFromCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_REMOVE_TO_CART_BUTTON, product))).click();
    }

    public void clickToCart() {
        driver.findElement(CART_BUTTON).click();
    }

    public String getButtonsText(String product) {
        return driver.findElement(By.xpath(String.format(ADD_REMOVE_TO_CART_BUTTON, product))).getText();
    }
}
