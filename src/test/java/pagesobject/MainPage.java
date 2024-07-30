package pagesobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private String headerText;
    private String textToCompare;
    // кнопка согласия с использованием кук
    private By cookieAgreeButton = By.cssSelector("#rcc-confirm-button");
    // заголовок аккордеона
    private By accordeonHeader;
    // текст аккордеона
    private By accordeonHiddenText;
    // кнопка заказа в хэдэре
    private By orderButtonInHeader = By.cssSelector(".Header_Nav__AGCXC.Button_Button__ra12g");
    // кнопка заказа в теле
    private By orderButtonInBody = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage(WebDriver driver, String headerText, String textToCompare) {
        this.driver = driver;
        this.headerText = headerText;
        this.textToCompare = textToCompare;
    }

    public void agreeToCookieUsage() {
        driver.findElement(cookieAgreeButton).click();
    }

    public String openAccordeonAndGetText() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        accordeonHeader = By.xpath(".//*[contains(text(), '" + headerText + "')]");
        driver.findElement(accordeonHeader).click();
        accordeonHiddenText = By.xpath(".//*[contains(text(), '" + headerText + "')]/../../div[@class='accordion__panel']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(accordeonHiddenText));
        return driver.findElement(accordeonHiddenText).getText();
    }

    public void clickOrderButtonInHeader() {
        driver.findElement(orderButtonInHeader).click();
    }

    public void clickOrderButtonInBody() {
        driver.findElement(orderButtonInBody).click();

    }
}