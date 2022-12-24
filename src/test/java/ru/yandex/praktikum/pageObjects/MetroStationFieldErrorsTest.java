package ru.yandex.praktikum.pageObjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class MetroStationFieldErrorsTest extends TestBase {
    private final String metroStationWithErrors;

    public MetroStationFieldErrorsTest(String metroStationWithErrors) {
        this.metroStationWithErrors = metroStationWithErrors;
    }

    @Parameterized.Parameters
    public static Object[][] getValue() {
        return new  Object[][] {
                {""},
                {"VDNKh"},
        };
    }

    @Test
    public void checkMetroStationFieldNegative() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.acceptCookie();
        objMainPage.clickOnOrderButtonHead();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.setWrongMetroStation(metroStationWithErrors);
        objOrderPage.clickOnNextButton();

        assertTrue("Должно высвечиваться сообщение Выберите станцию", objOrderPage.isMetroStationErrorVisible());
    }
}
