package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final By TITLE = By.cssSelector(".title"),
            TITLE_CHECKOUT_YOUR_INFORMATION = By.xpath("//*[text() = 'Checkout: Your Information']"),
            TITLE_CHECKOUT_OVERVIEW = By.xpath("//*[text() = 'Checkout: Overview']"),
            CHECKOUT_YOUR_INFORMATION_MESSAGE = By.xpath("//h3[contains(text(), 'Error')]"),
            CHECKOUT_BUTTON = By.id("checkout"),
            CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping"),
            CONTINUE_BUTTON = By.id("continue"),
            FIRST_NAME_FIELD = By.id("first-name"),
            LAST_NAME_FIELD = By.id("last-name"),
            ZIP_FIELD = By.id("postal-code");
    private static final String PRODUCT = "//*[text() = '%s']",
            REMOVE_BUTTON = "//*[text() = '%s']/ancestor::div[@class = 'cart_item_label']//button";

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public String getProductName(String product) {
        return driver.findElement(By.xpath(String.format(PRODUCT, product))).getText();
    }

    @Step("Нажатие копнки 'Remove' для товара с именем {product}")
    public void clickProductRemoveButton(String product) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, product))).click();
    }

    public ArrayList<String> getProductsName() {
        List<WebElement> allProductsElements = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsElements) {
            names.add(product.getText());
        }
        return names;
    }

    public String getProductPrice(String product) {
        return driver.findElement(
                By.xpath(String.format(
                        "//*[text() ='%s']/ancestor::div[@class = 'cart_item']//*[@class ='inventory_item_price']",
                        product))).getText().replace("$", "");
    }

    @Step("Нажатие копнки 'Checkout'")
    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("Нажатие копнки 'Continue Shopping'")
    public void clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public String getCheckoutYourInformationTitle() {
        return driver.findElement(TITLE_CHECKOUT_YOUR_INFORMATION).getText();
    }


    public String getCheckoutYourInformationMessage(){
        return driver.findElement(CHECKOUT_YOUR_INFORMATION_MESSAGE).getText();
    }

    public String getCheckoutOverviewTitle() {
        return driver.findElement(TITLE_CHECKOUT_OVERVIEW).getText();
    }
    @Step("Заполнение полей: Имя: {firstName}; Фамилия: {lastName}; Зип код: {zip}  и нажатие на кнопку 'Continue'")
    public void fillInCheckoutYourInformationData(String firstNane, String lastName, String zip) {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstNane);
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        driver.findElement(ZIP_FIELD).sendKeys(zip);
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
