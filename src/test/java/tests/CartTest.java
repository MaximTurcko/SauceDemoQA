package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {

    @Test
    public void checkCart() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "Products",
                "Логин не выполнен");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        softAssert.assertEquals(driver.findElement(By.id("remove-sauce-labs-backpack")).getText(), "Remove",
                "Кнопка добавления в карзину не нажата");
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        softAssert.assertEquals(driver.findElement(By.cssSelector(".inventory_item_price")).getText(), "$29.99",
                "Не правильная сумма");
        softAssert.assertAll();
    }

    @Test
    public void checkCartContainsProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bike Light");
        productsPage.clickToCart();
        Assert.assertEquals(cartPage.getProductName("Sauce Labs Bike Light"), "Sauce Labs Bike Light",
                "Товар не найден в карзине");
    }

    @Test
    public void checkRemoveButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bike Light");
        productsPage.clickToCart();
        cartPage.clickProductRemoveButton("Sauce Labs Bike Light");
        Assert.assertTrue(cartPage.searchProduct("Sauce Labs Bike Light"), "Продукт найден после удаления");
    }
}
