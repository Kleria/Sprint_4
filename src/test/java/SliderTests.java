
import org.junit.Test;


import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pagesobject.MainPage;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.hamcrest.MatcherAssert.assertThat;
    @RunWith(Parameterized.class)
    public class SliderTests extends BaseTest{
        private String accordeonLocator;
        private String accordeonTextLocator;
        private String textToCompare;
        @Parameterized.Parameters
        public static Object[][] checkSlidersData() {
            return new Object[][] {
                    { "#accordion__heading-0", "#accordion__panel-0 p", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    { "#accordion__heading-1", "#accordion__panel-1 p", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                    { "#accordion__heading-2", "#accordion__panel-2 p", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                    { "#accordion__heading-3", "#accordion__panel-3 p", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                    { "#accordion__heading-4", "#accordion__panel-4 p", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                    { "#accordion__heading-5", "#accordion__panel-5 p", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                    { "#accordion__heading-6", "#accordion__panel-6 p", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                    { "#accordion__heading-7", "#accordion__panel-7 p", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},

            };
        }

        public SliderTests(String accordeonLocator, String accordeonTextLocator, String textToCompare) {
            this.accordeonLocator = accordeonLocator;
            this.accordeonTextLocator = accordeonTextLocator;
            this.textToCompare = textToCompare;
        }
    @Test
    public void faqHasSlideresOpenTest() {
        MainPage objMainPage = new MainPage(driver, accordeonLocator, accordeonTextLocator, textToCompare);
        objMainPage.agreeToCookieUsage();
        objMainPage.openAccordeon();
        String accordeonText = objMainPage.getAccordeonText();
        assertThat(accordeonText, equalTo(textToCompare));
    }

}