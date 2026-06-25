package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final By TITLE = By.cssSelector(".title");
    private static final String PRODUCT = "//*[text() = '%s']",
            REMOVE_BUTTON = "//*[text() = '%s']/ancestor::div[@class = 'cart_item_label']//button";

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public String getProductName(String product) {
        return driver.findElement(By.xpath(String.format(PRODUCT, product))).getText();
    }

    public void clickProductRemoveButton(String product) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, product))).click();
    }

    public boolean searchProduct(String product) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.format(PRODUCT, product))));
    }
}
