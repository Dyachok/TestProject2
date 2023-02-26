Инструкция для теста "Напиши код на Java с использованием Selenium"
Этот тест предназначен для проверки функциональности формы на веб-странице https://demoqa.com/automation-practice-form.

Требования
Для выполнения этого теста вам понадобится:

Java
Selenium WebDriver
Браузер (например, Google Chrome)
Шаги теста
Открыть браузер и перейти на страницу https://demoqa.com/automation-practice-form.
Найти все поля формы и заполнить их валидными данными.
Нажать кнопку "Submit".
Проверить, что на странице появляется сообщение "Thanks for submitting the form".
Реализация теста
Пример кода на Java с использованием Selenium для выполнения этого теста:
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FormTest {
    public static void main(String[] args) {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Создание экземпляра драйвера Chrome
        WebDriver driver = new ChromeDriver();

        // Переход на страницу с формой
        driver.get("https://demoqa.com/automation-practice-form");

        // Находим все поля формы и заполняем их
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Doe");

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("johndoe@example.com");

        WebElement genderRadio = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
        genderRadio.click();

        WebElement mobileNumberInput = driver.findElement(By.id("userNumber"));
        mobileNumberInput.sendKeys("1234567890");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Проверяем, что на странице появляется сообщение "Thanks for submitting the form"
        WebElement successMessage = driver.findElement(By.cssSelector(".modal-content"));
        Assert.assertTrue(successMessage.getText().contains("Thanks for submitting the form"));

        // Закрытие браузера
        driver.quit();
    }
}

В этом примере мы используем Selenium WebDriver для заполнения формы и проверки сообщения об успешной отправке. Замените /path/to/chromedriver на путь к Chrome WebDriver на вашем компьютере.
