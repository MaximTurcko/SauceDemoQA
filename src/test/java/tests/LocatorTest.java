package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorTest extends BaseTest {
        /*
    1. Создать новый проект SauceDemo
2. Расшарить на Github и пригласить ментора в коллабораторы
3. Создать новый Java-класс, в нем для ресурса
https://www.saucedemo.com/ составить список локаторов, можно искать на
ВСЕХ страницах приложения (driver.findElement(<локатор>)) для КАЖДОГО из
примеров локаторов ниже:
• id
• name
• classname
• tagname
• linktext
• partiallinktext
• xpath:
- поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
- поиск по тексту, например By.xpath("//tag[text()='text']");
- поиск по частичному совпадению атрибута, например
By.xpath("//tag[contains(@attribute,'text')]");
- поиск по частичному совпадению текста, например
By.xpath("//tag[contains(text(),'text')]");
- ancestor, например //*[text()='Enterprise Testing']//ancestor::div
- descendant
- following
- parent
- preceding
- Подсказка: XPath Axes
- *поиск элемента с условием AND, например
//input[@class='_2zrpKA_1dBPDZ' and @type='text']
• css:
- .class
- .class1.class2
- .class1 .class2
- #id
- tagname

- tagname.class
- [attribute=value]
- [attribute~=value]
- [attribute|=value]
- [attribute^=value]
- [attribute$=value]
- [attribute*=value]
- Подсказка: https://www.w3schools.com/cssref/css_selectors.asp
     */

//    @Test
//    public void checkLocator() {
//        driver.get("https://www.saucedemo.com");
//        driver.findElement(By.id("user-name"));
//        driver.findElement(By.name("user-name"));
//        driver.findElement(By.className("error-message-container"));
//        driver.findElement(By.tagName("div"));
//        driver.findElement(By.linkText("Swag Labs"));
//        driver.findElement(By.partialLinkText("Swag"));
//        driver.findElement(By.xpath(
//                "(//input[@class='input_error form_input'])")).sendKeys("work");
//         driver.findElement(By.xpath(
//                "(//div[text()='Swag Labs'])")).getText();
//        driver.findElement(By.xpath(
//                "(//input[contains(@class, 'input_error')])"));
//        driver.findElement(By.xpath("(//div[contains(text(), 'Swag')])"));
//        driver.findElement(By.xpath("(//input[@class='input_error form_input']/ancestor::div)"));
//        driver.findElement(By.xpath(
//                "(//div[@class='form_column']/descendant::input[@class='input_error form_input'])"));
//        driver.findElement(By.xpath(
//                "(//div[@class='login_logo']/following-sibling::div)"));
//        driver.findElement(By.xpath(
//                "(//div[@class='login_wrapper']/preceding-sibling::div)"));
//        driver.findElement(By.xpath(
//                "(//div[@class='login_wrapper' and @data-test='login-container'])"));
//        driver.findElement(By.cssSelector(".login_logo"));
//        driver.findElement(By.cssSelector(".submit-button.btn_action"));
//        driver.findElement(By.cssSelector(".login_wrapper-inner .form_column"));
//        driver.findElement(By.cssSelector("#login-button"));
//        driver.findElement(By.cssSelector("input"));
//        driver.findElement(By.cssSelector("[type=text]"));
//        driver.findElement(By.cssSelector("[type~=text]"));
//        driver.findElement(By.cssSelector("[class|=login_credentials_wrap]"));
//        driver.findElement(By.cssSelector("[class*=login]"));
//    }

}

