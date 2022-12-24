package ru.yandex.praktikum.pageObjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class FirstNameFieldErrorsTest extends TestBase {
    private final String firstNameWithErrors;

    public FirstNameFieldErrorsTest(String firstNameWithErrors) {
        this.firstNameWithErrors = firstNameWithErrors;
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
    public void checkFirstNameFieldNegative() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.acceptCookie();
        objMainPage.clickOnOrderButtonHead();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.setFirstName(firstNameWithErrors);
        objOrderPage.clickOnNextButton();

        assertTrue("Должно высвечиваться сообщение Введите корректное имя", objOrderPage.isFirstNameErrorVisible());
    }
}
