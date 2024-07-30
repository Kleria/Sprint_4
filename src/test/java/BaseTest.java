import org.junit.After;

import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import constants.Const;

public class BaseTest {
    protected WebDriver driver;
    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get(Const.BASE_URL);
    }
    @After
    public void teardown() {
        driver.quit();
    }

}
