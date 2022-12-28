package ru.yandex.praktikum.pageObjects;

import static org.junit.Assert.*;
import org.junit.Test;

//доп.задание 1: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
public class ScooterLogoTest extends TestBase {

    //клик на кнопку Самокат на главной странице
    @Test
    public void checkGoToMainPage() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnScooterButton();
        boolean actualResult = objMainPage.checkMainPageOpened();

        assertTrue(actualResult);
    }

    //клик на кнопку Самокат из окна заказа (из шапки страницы)
    @Test
    public void checkGoToMainPageFromOrderHeadButton() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnOrderButtonHead();
        objMainPage.clickOnScooterButton();
        boolean actualResult = objMainPage.checkMainPageOpened();

        assertTrue(actualResult);
    }

    //клик на кнопку Самоката из окна заказа (из середины сайта)
    @Test
    public void checkGoToMainPageFromOrderBodyButton() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOnOrderButtonBody();
        objMainPage.clickOnScooterButton();
        boolean actualResult = objMainPage.checkMainPageOpened();

        assertTrue(actualResult);
    }

}