import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObj.MainPage;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.hamcrest.MatcherAssert.assertThat;

public class SliderTests {
    private WebDriver driver;
    @Before
    public void openChromeBrowser(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void faqHasSlideresOpenTest() {

        MainPage objMainPage = new MainPage(driver);
        objMainPage.agreeToCookieUsage();
        objMainPage.openAccordeon();
        String accordeonText = objMainPage.getAccordeonText();
        assertThat(accordeonText, equalTo("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."));
    }


    @After
    public void teardown() {
        driver.quit();
    }
}