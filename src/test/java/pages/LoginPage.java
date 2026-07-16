package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USER_NANE_FIELD = By.id("user-name"),
            PASSWORD_FIELD = By.id("password"),
            LOGIN_BUTTON = By.id("login-button"),
            ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    @Override
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    @Override
    @Step("Открытие страницы Login Page")
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Вход в систему с именем пользователя: {user} и паролем: {password}")
    public ProductsPage login(String user, String password) {
        driver.findElement(USER_NANE_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    public String getErrorMassage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
