import org.junit.After;

import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @After
    public void teardown() {
        driver.quit();
    }

}
