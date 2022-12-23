package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.By;

public class OrderPageLocators {
    // поле Имя
    protected By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    // поле Фамилия
    protected By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // поле Адрес
    protected By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле Станция метро
    protected By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    // поле Телефон
    protected By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка Далее
    protected By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");
    // поле Когда привезти самокат
    protected By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // поле Срок Аренды
    protected By rentalPeriodField = By.xpath(".//span[@class='Dropdown-arrow']");
    // чекбокс Цвет самоката - черный жемчуг
    protected By blackColorCheckBox = By.xpath(".//input[@id='black']");
    // чекбокс Цвет самоката - серая безысходность
    protected By greyColorCheckBox = By.xpath(".//input[@id='grey']");
    // поле Комментарий для курьера
    protected By commentField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // кнопка Назад
    protected By backButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Назад']");
    // кнопка Заказать
    protected By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Кнопка Да
    protected By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    // Кнопка Нет
    protected By noButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Нет']");
    // Подтверждение, что заказ создан
    protected By orderConfirm = By.xpath(".//div[text()='Заказ оформлен']");
}
