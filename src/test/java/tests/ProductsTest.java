package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @Test
    public void checkAddToCartButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        Assert.assertEquals(productsPage.getButtonsText("Sauce Labs Backpack"), "Remove");
    }

    @Test
    public void checkRemoveButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.removeProductFromCart("Sauce Labs Backpack");
        Assert.assertEquals(productsPage.getButtonsText("Sauce Labs Backpack"), "Add to cart");
    }

    @Test
    public void checkCartButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickToCart();
        Assert.assertEquals(cartPage.getTitle(), "Your Cart");
    }
}
