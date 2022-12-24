package ru.yandex.praktikum.pageObjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LastNameFieldErrorsTest extends TestBase {
    private final String lastNameWithErrors;

    public LastNameFieldErrorsTest(String lastNameWithErrors) {
        this.lastNameWithErrors = lastNameWithErrors;
    }

    @Parameterized.Parameters
    public static Object[][] getValue() {
        return new  Object[][] {
                {"G"},
                {"П"},
                {""},
                {"123"},
                {"@#$"},
        };
    }

    @Test
    public void checkLastNameFieldNegative() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.acceptCookie();
        objMainPage.clickOnOrderButtonHead();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.setLastName(lastNameWithErrors);
        objOrderPage.clickOnNextButton();

        assertTrue("Должно высвечиваться сообщение Введите корректную фамилию", objOrderPage.isLastNameErrorVisible());
    }
}
