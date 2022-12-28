package ru.yandex.praktikum.pageObjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AddressFieldErrorsTest extends TestBase {
    private final String addressWithErrors;

    public AddressFieldErrorsTest(String addressWithErrors) {
        this.addressWithErrors = addressWithErrors;
    }

    @Parameterized.Parameters
    public static Object[][] getValue() {
        return new  Object[][] {
                {"My home"},
                {"Дом"},
                {""},
                {"123"},
                {"@#$%^&&&"},
        };
    }

    @Test
    public void checkAddressFieldNegative() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.acceptCookie();
        objMainPage.clickOnOrderButtonHead();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.setAddress(addressWithErrors);
        objOrderPage.clickOnNextButton();

        assertTrue("Должно высвечиваться сообщение Введите корректный адрес", objOrderPage.isAddressErrorVisible());
    }

}
