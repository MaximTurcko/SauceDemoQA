package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @Test (testName = "Проверка валидного логина", description = "Удачный логин", priority = 5)
    public void checkSuccessLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test(testName = "Проверка валидности с пустым паролем", description = "Негативный логин", priority = 1)
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Password is required",
                "Не верная ошибка");
    }

    @Test (testName = "Проверка валидности c пустым логином", description = "Негативный тест", priority = 2)
    public void checkLoginWithEmptyLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Не верная ошибка");
    }

    @Test (testName = "Проверка валидности с пустыми полями", description = "Негативный тест" , priority = 3)
    public void checkLoginWithEmptyFields() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Не верная ошибка");
    }

    @Test (testName = "Проверка валидности с одним символом в поле пароль",  description = "Негативный тест",
            priority = 4)
    public void checkPasswordWithOneDigit() {
        loginPage.open();
        loginPage.login("standard_user", "1");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Не верная ошибка");
    }
}
