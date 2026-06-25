package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @Test
    public void checkSuccessLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Password is required",
                "Не верная ошибка");
    }

    @Test
    public void checkLoginWithEmptyLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Не верная ошибка");
    }

    @Test
    public void checkLoginWithEmptyFields() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Не верная ошибка");
    }

    @Test
    public void checkPasswordWithOneDigit() {
        loginPage.open();
        loginPage.login("standard_user", "1");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Не верная ошибка");
    }
}
