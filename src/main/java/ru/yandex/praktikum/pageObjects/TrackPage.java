package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrackPage {
    private WebDriver driver;

    public TrackPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка Статус заказа (доп.задание)
    private By orderStatus = By.xpath(".//button[text()='Статус заказа']");
    // Поле для ввода номера заказа
    private By fieldForOrderNumber = By.xpath(".//input[@placeholder='Введите номер заказа']");
    // Кнопка Go!
    private By goButton = By.xpath(".//button[text()='Go!']");
    // Картинка для ненайденного заказа
    private By notFoundPicture = By.xpath(".//img[@alt='Not found']");


    //клик на кнопку Статус заказа
    public void clickOnOrderStatusButton() {
        driver.findElement(orderStatus).click();
    }

    //ввод номера заказа
    public void setOrderNumber(int orderNumber) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(fieldForOrderNumber));
        driver.findElement(fieldForOrderNumber).sendKeys(Integer.toString(orderNumber));
    }

    //клик на кнопку Go!
    public void clickOnGoButton() {
        driver.findElement(goButton).click();
    }

    //проверка, что объект не найден
    public boolean checkOrderNotFound() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(notFoundPicture));
        return driver.findElement(notFoundPicture).isDisplayed();
    }

    //общий шаг для проверки, что заказ не найден
    public boolean isOrderNotFound(int orderNumber) {
        clickOnOrderStatusButton();
        setOrderNumber(orderNumber);
        clickOnGoButton();
        return checkOrderNotFound();
    }
}
