package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;

// главная страница
public class MainPage {
    private By cookieButton = By.xpath(".//button[text()='да все привыкли']");
    // кнопка Яндекса (переход на главную страницу яндекса) (доп.задание)
    private By yandexButton = By.xpath(".//img[@alt='Yandex']");
    // кнопка Самокат (доп.задание)
    private By scooterLogoButton = By.xpath(".//img[@alt='Scooter']");
    // Элемент с текстом "Самокат на пару дней"
    private By ScooterOnFewDaysElement = By.xpath(".//div[text()='Самокат ']");
    // Кнопка Заказать в шапке страницы
    private By orderButtonHead = By.xpath(".//button[@class='Button_Button__ra12g']");
    // Кнопка Заказать внизу страницы
    private By orderButtonBody = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //локатор для списка вопросов
    private By listOfQuestions = By.className("accordion");

    //url главной страницы яндекса
    private final String yandexUrl = "https://dzen.ru/?yredirect=true";
    
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

    //геттер урла главной страницы Яндекса
    public String getYandexUrl() {
        return yandexUrl;
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

    // массив с ожидаемыми ответами на вопросы
    String[] expectedAnswersArray = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, " +
                    "когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. " +
                    "Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    // скролл до блока вопросов, раскрытие вопроса, получение текста ответа
    public String getAnswerText(int questionsNumber) {
        WebElement element = driver.findElement(listOfQuestions);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(By.xpath(".//div[@class='accordion']/div["+ questionsNumber + "]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String idOfElementWithAnswerText = String.format("accordion__panel-%d", questionsNumber-1);

        return driver.findElement(By.id(idOfElementWithAnswerText)).getText();
    }

}
