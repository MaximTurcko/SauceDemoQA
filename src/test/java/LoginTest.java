import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {


    @Test
    public void checkSuccessLogin() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "Products",
                "Логин не выполнен");
    }

    @Test
    public void checkLoginWithEmptyPassword(){
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".error-message-container.error")).isDisplayed(),
                true, "Логин не выполнен");
    }

    @Test
    public void checkLoginWithEmptyLogin(){
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".error-message-container.error")).isDisplayed(),
                true, "Логин не выполнен");
    }

    @Test
    public void checkPasswordWithOneDigit() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("1");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".error-message-container.error")).isDisplayed(),
                true, "Логин не выполнен");
    }

}
