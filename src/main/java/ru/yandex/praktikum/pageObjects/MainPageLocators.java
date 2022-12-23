package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.By;

public class MainPageLocators {
    // кнопка для принятия куки
    protected By cookieButton = By.xpath(".//button[text()='да все привыкли']");
    // кнопка Яндекса (переход на главную страницу яндекса) (доп.задание)
    protected By yandexButton = By.xpath(".//img[@alt='Yandex']");
    // кнопка Самокат (доп.задание)
    protected By scooterLogoButton = By.xpath(".//img[@alt='Scooter']");
    // Элемент с текстом "Самокат на пару дней"
    protected By ScooterOnFewDaysElement = By.xpath(".//div[text()='Самокат ']");
    // Кнопка Заказать в шапке страницы
    protected By orderButtonHead = By.xpath(".//button[@class='Button_Button__ra12g']");
    // Кнопка Заказать внизу страницы
    protected By orderButtonBody = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
}
