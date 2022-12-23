package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class QuestionsPage {
    private WebDriver driver;

    //локатор для списка вопросов
    private By listOfQuestions = By.className("accordion");

    public QuestionsPage(WebDriver driver) {
        this.driver = driver;
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
