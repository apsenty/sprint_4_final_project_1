package ru.yandex.praktikum.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//страница заказа
public class OrderPage extends OrderPageLocators {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //ввод имени
    public void setFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    // ввод фамилии
    public void setLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    // ввод адреса
    public void setAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }

    // метод для ввода станции метро
    public void setMetroStation(String metroStation) {
        driver.findElement(metroField).click();
        driver.findElement(metroField).sendKeys(metroStation);
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='" + metroStation + "']")));
        driver.findElement(By.xpath(".//div[text()='" + metroStation + "']")).click();
    }

    // метод для ввода станции метро (только для негативных тестов)
    public void setWrongMetroStation(String metroStation) {
        driver.findElement(metroField).click();
        driver.findElement(metroField).sendKeys(metroStation);
        driver.findElement(metroField).click();
    }

    //ввод номера телефона
    public void setPhoneNumber(String phoneNumber){
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    //клик на кнопку Далее
    public void clickOnNextButton(){
        driver.findElement(nextButton).click();
    }

    //ввод даты
    public void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    // метод для выбора срока аренды на двое суток
    public void setRentalPeriod(String period){
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='" + period + "']")).click();
    }

    // метод выбора цвета самоката в зависимости от того, какой цвет выбран
    public void setScooterColor(String color) {
        if(color.equals("black")){
            driver.findElement(blackColorCheckBox).click(); // если черный жемчуг
        } else if(color.equals("grey")) {
            driver.findElement(greyColorCheckBox).click(); // если серая безысходность
        }
    }

    //ввод комментария
    public void setComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }

    //клик на кнопку Заказать
    public void clickOnOrderButton() {
        driver.findElement(orderButton).click();
    }

    //клик на кнопку Да
    public void clickOnYes() {
        driver.findElement(yesButton).click();
    }

    //клик на кнопку Нет
    public void clickOnNo() {
        driver.findElement(noButton).click();
    }

    // метод для проверки, что заказ создан (проверка окна с фразой Заказ оформлен)
    public boolean checkOrderConfirm() {
        String confirmMessage = driver.findElement(orderConfirm).getText();
        return confirmMessage.equals("Заказ оформлен");
    }

    // один большой метод оформления заказа
    public void createOrder(String firstName, String lastName, String address, String metroStation, String phoneNumber,
                            String date, String period, String color, String comment) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
        clickOnNextButton();
        setDate(date);
        setRentalPeriod(period);
        setScooterColor(color);
        setComment(comment);
        clickOnOrderButton();
        clickOnYes();
    }

    // проверка высвечивания ошибки "Введите корректное имя"
    public boolean isFirstNameErrorVisible() {
        return driver.findElement(firstNameError).isDisplayed();
    }
    // проверка высвечивания "Введите корректную фамилию"
    public boolean isLastNameErrorVisible() {
        return driver.findElement(lastNameError).isDisplayed();
    }
    // проверка высвечивания "Введите корректный адрес"
    public boolean isAddressErrorVisible() {
        return driver.findElement(addressError).isDisplayed();
    }
    // проверка высвечивания "Выберите станцию"
    public boolean isMetroStationErrorVisible() {
        return driver.findElement(metroError).isDisplayed();
    }
    // проверка высвечивания "Введите корректный номер"
    public boolean isPhoneErrorVisible() {
        return driver.findElement(phoneError).isDisplayed();
    }
    // проверка высвечивания ошибки "Выберите дату" !!!локатор выдуманный!!!
    public boolean isDateErrorVisible() {
        return driver.findElement(dateError).isDisplayed();
    }
    // проверка высвечивания ошибки "Выберите срок аренды" !!!локатор выдуманный!!!
    public boolean isRentalPeriodErrorVisible() {
        return driver.findElement(rentalPeriodError).isDisplayed();
    }
}
