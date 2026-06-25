package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USER_NANE_FIELD = By.id("user-name");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_FIELD = By.id("login-button");
    private static final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String user, String password) {
        driver.findElement(USER_NANE_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_FIELD).click();
    }

    public String getErrorMassage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
