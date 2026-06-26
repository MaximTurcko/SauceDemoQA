package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    WebDriver driver;
    public static final String BASE_URL = "https://www.saucedemo.com";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void isElementPresent(By locator){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        List<WebElement> elements = driver.findElements(locator);
        Assert.assertEquals(elements.size(), 0);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
