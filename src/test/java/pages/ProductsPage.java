package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final By TITLE = By.cssSelector("[data-test = title]");
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private static final String ADD_REMOVE_TO_CART_BUTTON = "//*[text() = '%s']/ancestor::div" +
            "[@class = 'inventory_item']//button";

    @Override
    public ProductsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CART_BUTTON));
        }  catch (TimeoutException e){
            log.error(e.getMessage());
            Assert.fail("Products page hasn't opened");
        }
        return this;
    }

    @Override
    public BasePage open() {
        return null;
    }

    public String getTitle() {
        log.info("Getting title");
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавление товара с именем: {product} в корзину")
    public ProductsPage addProductToCart(String product) {
        log.info("Adding product '{}' to Cart", product);
        driver.findElement(By.xpath(String.format(ADD_REMOVE_TO_CART_BUTTON, product))).click();
        return this;
    }

    @Step("Нажатие кнопки 'Remove' товара с именем: {product}")
    public ProductsPage removeProductFromCart(String product) {
        log.info("Removing product '{}' from Cart", product);
        driver.findElement(By.xpath(String.format(ADD_REMOVE_TO_CART_BUTTON, product))).click();
        return this;
    }

    @Step("Нажатие кнопки 'Корзина'")
    public CartPage clickToCart() {
        log.info("Pressing 'Cart' button");
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }

    public String getButtonsText(String product) {
        log.info("Getting product's '{}' button text", product);
        return driver.findElement(By.xpath(String.format(ADD_REMOVE_TO_CART_BUTTON, product))).getText();
    }
}
