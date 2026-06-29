package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class CartTest extends BaseTest {

    @Test (testName = "Проверка наличия продукта в карзине", description = "Тест карзины", priority = 1)
    public void checkCartContainsProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bike Light");
        productsPage.clickToCart();
        Assert.assertEquals(cartPage.getProductName("Sauce Labs Bike Light"), "Sauce Labs Bike Light",
                "Товар не найден в карзине");
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bike Light"),"9.99",
                "Не правильная цена");
    }

    @Test (testName = "Проверка валидности кнопки 'Remove'", description = "Тест кнопки", priority = 4,
    dependsOnMethods = {"checkCartContainsProduct"})
    public void checkRemoveButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bike Light");
        productsPage.clickToCart();
        cartPage.clickProductRemoveButton("Sauce Labs Bike Light");
        Assert.assertFalse(cartPage.getProductsName().contains("Sauce Labs Bike Light"),
                "Продукт не найден");
    }

    @Test (testName = "Проверка валидности конпки 'Checkout'", description = "Тест кнопки", priority = 2)
    public void checkCheckoutButton (){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickToCart();
        cartPage.clickCheckoutButton();
        Assert.assertEquals(cartPage.getCheckoutYourInformationTitle(), "Checkout: Your Information",
                "Переход на страницу оплаты не выполнен");
    }

    @Test (testName = "Проверка валидности кнопки 'Continue Shopping'", description = "Тест кнопки", priority = 5)
    public void checkContinueShoppingButton (){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickToCart();
        cartPage.clickContinueShoppingButton();
        Assert.assertEquals(productsPage.getTitle(), "Products",
                "Переход на страницу продуктов не выполнен");
    }

    @DataProvider
    public Object[][] checkoutData(){
        return new Object[][] {
                {"", "", "", "Error: First Name is required"},
                {"", "dawd", "24324", "Error: First Name is required"},
                {"gdf", "", "24324", "Error: Last Name is required"},
                {"gdf", "dawd", "", "Error: Postal Code is required"}
        };
    }

    @Test (testName = "Проверка наличия продукта в карзине", description = "Тест карзины",
            dataProvider = "checkoutData", priority = 3)
    public void checkCheckoutYourInformationFields (String firstName, String lastName, String zip, String message){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickToCart();
        cartPage.clickCheckoutButton();
        cartPage.fillInCheckoutYourInformationData(firstName, lastName, zip);
        Assert.assertEquals(cartPage.getCheckoutYourInformationMessage(), message,
                "Не верный результат ввода данных");
    }
}
