package ru.yandex.praktikum.pageObjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderScooterTest extends TestBase {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;

    public OrderScooterTest(String firstName, String lastName, String address,
                            String metroStation, String phoneNumber, String date, String period, String color,
                            String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getValue() {
        return new  Object[][] {
                {"Ольга", "Полякова", "Мой дом", "Черкизовская", "+79854908727", "20.12.2022", "сутки", "black", "Комментарий 1"},
                {"Александр", "Третьяков", "Новый дом", "ВДНХ", "+79851641647", "21.12.2022", "трое суток", "grey", "Комментарий 2"},
        };
    }

    @Test
    public void checkCreateOrderHeadButtonPositive() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnOrderButtonHead();
        objMainPage.acceptCookie();

        OrderPage objOrder = new OrderPage(driver);
        objOrder.createOrder(firstName, lastName, address, metroStation, phoneNumber, date, period, color, comment);

        boolean actualResult = objOrder.checkOrderConfirm();

        assertTrue("Текст сообщения должен быть Заказ оформлен", actualResult);
    }

    @Test
    public void checkCreateOrderBodyButtonPositive() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnOrderButtonBody();
        objMainPage.acceptCookie();

        OrderPage objOrder = new OrderPage(driver);
        objOrder.createOrder(firstName, lastName, address, metroStation, phoneNumber, date, period, color, comment);

        boolean actualResult = objOrder.checkOrderConfirm();

        assertTrue("Текст сообщения должен быть Заказ оформлен", actualResult);
    }

}