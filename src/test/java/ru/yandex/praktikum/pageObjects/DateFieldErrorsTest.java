package ru.yandex.praktikum.pageObjects;

// в DOM-дереве сайта не прописан текст ошибки для пропуска поля "Когда привезти самокат"
// в рамках проекта тест будет падать, потому что я сама придумала локатор для ошибки "Выберите дату"
// и описала здесь тест, якобы проверяющий видимость этой ошибки

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class DateFieldErrorsTest extends TestBase {

    @Test
    public void checkDateFieldNegative() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.acceptCookie();
        objMainPage.clickOnOrderButtonHead();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.setFirstName("Ольга");
        objOrderPage.setLastName("Полякова");
        objOrderPage.setAddress("Мой дом");
        objOrderPage.setMetroStation("Речной вокзал");
        objOrderPage.setPhoneNumber("+79859009090");
        objOrderPage.clickOnNextButton();
        objOrderPage.clickOnOrderButton();

        assertTrue("Должно высвечиваться сообщение Выберите дату", objOrderPage.isDateErrorVisible());

    }
}
