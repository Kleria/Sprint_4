package pagesobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderFormDetails {
    private WebDriver driver;
    // датапикер
    private By datapicker = By.className("react-datepicker__input-container");
    // выпадушка срока аренды
    private By dropdown = By.cssSelector(".Dropdown-arrow");
    // выбор самоката
    private By kickScooter = By.cssSelector("#black");
    //кнопка заказа
    private By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text() = 'Заказать']");



    public OrderFormDetails(WebDriver driver){
        this.driver = driver;
    }

    public void setDate() {
        driver.findElement(datapicker).click();
        driver.findElement(By.xpath(".//div[text() = '30']")).click();
    }

    public void setPeriod(){
        driver.findElement(dropdown).click();
        driver.findElement(By.xpath("//div[text() = 'двое суток']")).click();
    }
    public void selectKickScooter(){
        driver.findElement(kickScooter).click();
    }

    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }
}



