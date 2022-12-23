package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

// главная страница
public class MainPage extends MainPageLocators {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // закрытие плашки с куками
    public void acceptCookie() {
        driver.findElement(cookieButton).click();
    }

    // нажатие на кнопку оформления заказа в шапке сайта
    public void clickOnOrderButtonHead() {
        driver.findElement(orderButtonHead).click();
    }

    // нажатие на кнопку оформления заказа в теле сайта
    public void clickOnOrderButtonBody() {
        WebElement element = driver.findElement(orderButtonBody);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderButtonBody).click();
    }

    // нажатие на кнопку Самокат
    public void clickOnScooterButton() {
        driver.findElement(scooterLogoButton).click();
    }

    // проверка, что открылась главная страница
    public boolean checkMainPageOpened() {
        return driver.findElement(ScooterOnFewDaysElement).isDisplayed();
    }

    //нажатие на логотип Яндекса
    public void clickOnYandexLogo() {
        driver.findElement(yandexButton).click();
    }

    //переключение на открывшуюся вкладку
    public void switchToNewTab() {
        String originalWindow = driver.getWindowHandle();
        clickOnYandexLogo();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

}
