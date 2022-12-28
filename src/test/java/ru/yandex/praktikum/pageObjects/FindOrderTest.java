package ru.yandex.praktikum.pageObjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FindOrderTest extends TestBase {
    private final int orderNumber;


    public FindOrderTest(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Parameterized.Parameters
    public static Object[][] setOrderNumbers() {
        return new Object[][] {
                {1},
                {0},
                {1563324},
        };
    }

    @Test
    public void checkWrongOrderNumber() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.acceptCookie();

        TrackPage objTrackPage = new TrackPage(driver);
        boolean actual = objTrackPage.isOrderNotFound(orderNumber);

        assertTrue(actual);
    }
}