package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @Test(testName = "Проверка валидности нажатия кнопки 'Add To Cart'", description = "Тест кнопки 'Add To Cart'",
            priority = 3)
    @Epic("Главная страница с товарами")
    @Feature("Действия с товарами")
    @Story("Добавление товара в корзину")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка нажатия кнопки 'Add to Cart'")
    @Link(name = "Страница товаров", url = "https://www.saucedemo.com/inventory.html")
    @TmsLink("TMS_Test_case_8")
    public void checkAddToCartButton() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce");
        productsPage.isPageOpened()
                .addProductToCart("Sauce Labs Backpack");
        Assert.assertEquals(productsPage.getButtonsText("Sauce Labs Backpack"), "Remove");
    }

    @Test(testName = "Проверка валидности нажатия кнопки 'Remove'", description = "Тест кнопки 'Remove'", priority = 2)
    @Epic("Главная страница с товарами")
    @Feature("Действия с товарами")
    @Story("Удаление товара из корзины")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка нажатия кнопки 'Remove'")
    @Link(name = "Страница товаров", url = "https://www.saucedemo.com/inventory.html")
    @TmsLink("TMS_Test_case_7")
    public void checkRemoveButton() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce");
        productsPage.isPageOpened()
                .addProductToCart("Sauce Labs Backpack")
                .removeProductFromCart("Sauce Labs Backpack");
        Assert.assertEquals(productsPage.getButtonsText("Sauce Labs Backpack"), "Add to cart");
    }

    @Test(testName = "Проверка валидности нажатия кнопки 'Cart'", description = "Тест кнопки 'Cart'", priority = 1)
    @Epic("Главная страница с товарами")
    @Feature("Действия с товарами")
    @Story("Добавление товара в корзину")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка нажатия кнопки 'Корзина'")
    @Link(name = "Страница товаров", url = "https://www.saucedemo.com/inventory.html")
    @TmsLink("TMS_Test_case_6")
    public void checkCartButton() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce");
        productsPage.isPageOpened()
                .clickToCart();
        Assert.assertEquals(cartPage.getTitle(), "Your Cart");
    }
}
