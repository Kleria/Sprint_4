package pagesobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderFormPersonalInfo {

    private WebDriver driver;
    private String clientName;
    private String clientSurname;
    private String clientAddress;
    private String clientMetroStation;
    private String clientPhoneNumber;

    // Поля для ввода
    private By nameField = By.cssSelector("input[placeholder='* Имя']");
    private By surnameField = By.cssSelector("input[placeholder='* Фамилия']");
    private By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private By metroStationList = By.cssSelector(".select-search");
    private By phoneNumberField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private By forwardButton = By.className("Button_Middle__1CSJM");

    public OrderFormPersonalInfo(WebDriver driver, String clientName, String clientSurname,
                                 String clientAddress, String clientMetroStation,
                                 String clientPhoneNumber) {
        this.driver = driver;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientAddress = clientAddress;
        this.clientMetroStation = clientMetroStation;
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public void fillInNameAndAddress(){
        driver.findElement(nameField).sendKeys(clientName);
        driver.findElement(surnameField).sendKeys(clientSurname);
        driver.findElement(addressField).sendKeys(clientAddress);
        driver.findElement(metroStationList).click();
        driver.findElement(By.xpath("//*[contains(text(), '" + clientMetroStation + "')]")).click();
        driver.findElement(phoneNumberField).sendKeys(clientPhoneNumber);
    }

    public void clickForwardButton(){
        driver.findElement(forwardButton).click();
    }
}