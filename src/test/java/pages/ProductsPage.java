package pages;

import io.qameta.allure.Step;
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
    @Step("Добавление товара с именем: {product} в корзину")
    public void addProductToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_REMOVE_TO_CART_BUTTON, product))).click();
    }

    @Step("Нажатие кнопки 'Remove' товара с именем: {product}")
    public void removeProductFromCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_REMOVE_TO_CART_BUTTON, product))).click();
    }

    @Step("Нажатие кнопки 'Корзина'")
    public void clickToCart() {
        driver.findElement(CART_BUTTON).click();
    }

    public String getButtonsText(String product) {
        return driver.findElement(By.xpath(String.format(ADD_REMOVE_TO_CART_BUTTON, product))).getText();
    }
}
