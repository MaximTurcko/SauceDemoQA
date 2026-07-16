package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CART_BUTTON));
        return this;
    }

    @Override
    public BasePage open() {
        return null;
    }

    private static final By TITLE = By.cssSelector("[data-test = title]");
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private static final String ADD_REMOVE_TO_CART_BUTTON = "//*[text() = '%s']/ancestor::div" +
            "[@class = 'inventory_item']//button";

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавление товара с именем: {product} в корзину")
    public ProductsPage addProductToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_REMOVE_TO_CART_BUTTON, product))).click();
        return this;
    }

    @Step("Нажатие кнопки 'Remove' товара с именем: {product}")
    public ProductsPage removeProductFromCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_REMOVE_TO_CART_BUTTON, product))).click();
        return this;
    }

    @Step("Нажатие кнопки 'Корзина'")
    public CartPage clickToCart() {
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }

    public String getButtonsText(String product) {
        return driver.findElement(By.xpath(String.format(ADD_REMOVE_TO_CART_BUTTON, product))).getText();
    }
}
