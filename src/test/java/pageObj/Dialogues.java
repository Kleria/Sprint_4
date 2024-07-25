package pageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dialogues {
    private WebDriver driver;
    // кнопка Подтверждения
    private By yesButton = By.xpath("//button[text() = 'Да']");

    private By orderConfirmed = By.className("Order_ModalHeader__3FDaJ");


    public Dialogues(WebDriver driver){
        this.driver = driver;
    }
    public void clickYesButton(){
        driver.findElement(yesButton).click()
        ;
    }

    public String orderConfirmedText(){
        return driver.findElement(orderConfirmed).getText();
    }
}
