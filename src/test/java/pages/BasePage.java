package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public static final String BASE_URL = "https://www.saucedemo.com";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public abstract BasePage isPageOpened();
    public abstract BasePage open();

    public void isElementPresent(By locator){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        List<WebElement> elements = driver.findElements(locator);
        Assert.assertEquals(elements.size(), 0);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
