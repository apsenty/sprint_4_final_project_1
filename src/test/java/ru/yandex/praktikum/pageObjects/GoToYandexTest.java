package ru.yandex.praktikum.pageObjects;

import org.junit.Test;

import static org.junit.Assert.*;

//доп. задание 2: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса
public class GoToYandexTest extends TestBase {

    //клик на лого Яндекса с главной страницы
    @Test
    public void checkGoToYandexFromMainPage() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.switchToNewTab();
        String URL = driver.getCurrentUrl();
        String yandexUrl = objMainPage.getYandexUrl();

        assertEquals(yandexUrl, URL);
    }

    // клик на лого Яндекса из окна заказа (из шапки страницы)
    @Test
    public void checkGoToYandexFromOrderPageHead() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnOrderButtonHead();
        objMainPage.switchToNewTab();
        String URL = driver.getCurrentUrl();
        String yandexUrl = objMainPage.getYandexUrl();

        assertEquals(yandexUrl, URL);
    }

    // клик на лого Яндекса из окна заказа (из середины сайта)
    @Test
    public void checkGoToYandexFromOrderPageBody() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnOrderButtonBody();
        objMainPage.switchToNewTab();
        String URL = driver.getCurrentUrl();
        String yandexUrl = objMainPage.getYandexUrl();

        assertEquals(yandexUrl, URL);
    }
}