package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(testName = "Проверка валидного логина", description = "Удачный логин", priority = 5)
    @Epic("Авторизация")
    @Feature("Страница логина")
    @Story("Позитивный логин")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка успешного логина")
    @Link(name = "Страница логина", url = "https://www.saucedemo.com")
    @TmsLink("TMS_Test_case_5")
    public void checkSuccessLogin() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce")
                .isPageOpened();
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test(testName = "Проверка валидности с пустым паролем", description = "Негативный логин", priority = 1)
    @Epic("Авторизация")
    @Feature("Страница логина")
    @Story("Негативный логин")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка логина с пустым полем 'Пароль'")
    @Link(name = "Страница логина", url = "https://www.saucedemo.com")
    @TmsLink("TMS_Test_case_1")
    public void checkLoginWithEmptyPassword() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Password is required",
                "Не верная ошибка");
    }

    @Test(testName = "Проверка валидности c пустым логином", description = "Негативный тест", priority = 2)
    @Epic("Авторизация")
    @Feature("Страница логина")
    @Story("Негативный логин")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка логина с пустым полем 'Логин'")
    @Link(name = "Страница логина", url = "https://www.saucedemo.com")
    @TmsLink("TMS_Test_case_2")
    public void checkLoginWithEmptyLogin() {
        loginPage.open()
                .isPageOpened()
                .login("", "secret_sauce");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Не верная ошибка");
    }

    @Test(testName = "Проверка валидности с пустыми полями", description = "Негативный тест", priority = 3)
    @Epic("Авторизация")
    @Feature("Страница логина")
    @Story("Негативный логин")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка логина с пустыми полями 'Логин' и 'Пароль'")
    @Link(name = "Страница логина", url = "https://www.saucedemo.com")
    @TmsLink("TMS_Test_case_3")
    public void checkLoginWithEmptyFields() {
        loginPage.open()
                .isPageOpened()
                .login("", "");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Не верная ошибка");
    }

    @Test(testName = "Проверка валидности с одним символом в поле пароль", description = "Негативный тест",
            priority = 4)
    @Epic("Авторизация")
    @Feature("Страница логина")
    @Story("Негативный логин")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка логина с 1 символом в поле 'Пароль'")
    @Link(name = "Страница логина", url = "https://www.saucedemo.com")
    @TmsLink("TMS_Test_case_4")
    public void checkPasswordWithOneDigit() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "1");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Не верная ошибка");
    }
}
