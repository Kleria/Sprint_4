
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pagesobject.Dialogues;
import pagesobject.MainPage;
import pagesobject.OrderFormDetails;
import pagesobject.OrderFormPersonalInfo;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest{

    private String clientName;
    private String clientSurname;
    private String clientAddress;
    private String clientMetroStation;
    private String clientPhoneNumber;

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                { "Сергей", "Иванов", "Пушкина 3", "Кропоткинская", "89998887766"},
                { "Светана", "Светляков", "Октября 43", "Сокольники", "81112223344"},
        };
    }

    public OrderTest(String clientName, String clientSurname, String clientAddress,
                     String clientMetroStation, String clientPhoneNumber) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientAddress = clientAddress;
        this.clientMetroStation = clientMetroStation;
        this.clientPhoneNumber = clientPhoneNumber;
    }
    @Test
    public void createASuccessfulOrderWithButtonInHeaderTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.agreeToCookieUsage();
        mainPage.clickOrderButtonInHeader();

        OrderFormPersonalInfo objOrderPersInfo = new OrderFormPersonalInfo(driver, clientName, clientSurname, clientAddress, clientMetroStation, clientPhoneNumber);
        objOrderPersInfo.fillInNameAndAddress();
        objOrderPersInfo.clickForwardButton();

        OrderFormDetails objOrderFormDetails = new OrderFormDetails(driver);
        objOrderFormDetails.setDate();
        objOrderFormDetails.setPeriod();
        objOrderFormDetails.selectKickScooter();
        objOrderFormDetails.clickOrderButton();

        Dialogues objDialogues = new Dialogues(driver);
        objDialogues.clickYesButton();

        String confirmationText = objDialogues.orderConfirmedText();
        assertThat(confirmationText, startsWith("Заказ оформлен"));
    }

    @Test
    public void createASuccessfulOrderWithButtonInBodyTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.agreeToCookieUsage();
        mainPage.clickOrderButtonInBody();

        OrderFormPersonalInfo objOrderPersInfo = new OrderFormPersonalInfo(driver, clientName, clientSurname, clientAddress, clientMetroStation, clientPhoneNumber);
        objOrderPersInfo.fillInNameAndAddress();
        objOrderPersInfo.clickForwardButton();

        OrderFormDetails objOrderFormDetails = new OrderFormDetails(driver);
        objOrderFormDetails.setDate();
        objOrderFormDetails.setPeriod();
        objOrderFormDetails.selectKickScooter();
        objOrderFormDetails.clickOrderButton();

        Dialogues objDialogues = new Dialogues(driver);
        objDialogues.clickYesButton();

        String confirmationText = objDialogues.orderConfirmedText();
        assertThat(confirmationText, startsWith("Заказ оформлен"));
    }

}