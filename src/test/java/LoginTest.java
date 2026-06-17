import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        driver.get("https://www.saucedemo.com");
    }
}
