package ru.yandex.praktikum.pageObjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class PhoneFieldsErrorsTest extends TestBase {
    private final String phoneWithErrors;

    public PhoneFieldsErrorsTest(String phoneWithErrors) {
        this.phoneWithErrors = phoneWithErrors;
    }

    @Parameterized.Parameters
    public static Object[][] getValue() {
        return new  Object[][] {
                {""},
                {"my phone"},
                {"мой телефон"},
                {"9859009090"},
                {"+7(985)900-90-90"}
        };
    }

    @Test
    public void checkPhoneFieldNegative() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.acceptCookie();
        objMainPage.clickOnOrderButtonHead();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.setPhoneNumber(phoneWithErrors);
        objOrderPage.clickOnNextButton();

        assertTrue("Должно высвечиваться сообщение Введите корректный номер", objOrderPage.isPhoneErrorVisible());

    }
}
