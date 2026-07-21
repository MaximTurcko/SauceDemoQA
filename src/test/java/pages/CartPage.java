package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

@Log4j2
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

    @Override
    public CartPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
        }  catch (TimeoutException e){
            log.error(e.getMessage());
            Assert.fail("Cart page hasn't opened");
        }
        return this;
    }

    @Override
    public CartPage open() {
        return null;
    }

    @Step("Нажатие копнки 'Remove' для товара с именем {product}")
    public CartPage clickProductRemoveButton(String product) {
        log.info("Pressing product's '{}' 'Remove' button", product);
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, product))).click();
        return this;
    }

    public ArrayList<String> getProductsName() {
        log.info("Getting product names");
        List<WebElement> allProductsElements = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsElements) {
            names.add(product.getText());
        }
        return names;
    }

    public String getTitle() {
        log.info("Getting title: '{}'", TITLE);
        return driver.findElement(TITLE).getText();
    }

    public String getProductName(String product) {
        log.info("Getting product '{}' name", product);
        return driver.findElement(By.xpath(String.format(PRODUCT, product))).getText();
    }

    public String getProductPrice(String product) {
        return driver.findElement(
                By.xpath(String.format(
                        "//*[text() ='%s']/ancestor::div[@class = 'cart_item']//*[@class ='inventory_item_price']",
                        product))).getText().replace("$", "");
    }

    @Step("Нажатие копнки 'Checkout'")
    public CartPage clickCheckoutButton() {
        log.info("Pressing 'Checkout' button");
        driver.findElement(CHECKOUT_BUTTON).click();
        return this;
    }

    @Step("Нажатие копнки 'Continue Shopping'")
    public ProductsPage clickContinueShoppingButton() {
        log.info("Pressing 'Continue Shopping' button");
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new ProductsPage(driver);
    }

    public String getCheckoutYourInformationTitle() {
        log.info("Getting 'Checkout Your Information' title");
        return driver.findElement(TITLE_CHECKOUT_YOUR_INFORMATION).getText();
    }


    public String getCheckoutYourInformationMessage(){
        log.info("Getting 'Checkout Your Information' message");
        return driver.findElement(CHECKOUT_YOUR_INFORMATION_MESSAGE).getText();
    }

    public String getCheckoutOverviewTitle() {
        return driver.findElement(TITLE_CHECKOUT_OVERVIEW).getText();
    }

    @Step("Заполнение полей: Имя: {firstName}; Фамилия: {lastName}; Зип код: {zip}  и нажатие на кнопку 'Continue'")
    public void fillInCheckoutYourInformationData(String firstNane, String lastName, String zip) {
        log.info("Filling in 'Checkout Your Information' fields with Data: First name: '{}', " +
                "Last name: '{}', Zip: '{}'", firstNane, lastName, zip);
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstNane);
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        driver.findElement(ZIP_FIELD).sendKeys(zip);
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
