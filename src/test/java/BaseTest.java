import org.junit.After;
import constants.Const;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
