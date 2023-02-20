import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormFillAutomation {
    private static Object Keys;

    public static void main(String[] args) {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "/Users/ivandiachok/Downloads/chromedriver_mac_arm64/chromedriver");

        // Создание экземпляра драйвера Chrome
        WebDriver driver = new ChromeDriver();

        // Переход на страницу с формой
        driver.get("https://demoqa.com/automation-practice-form");

        // Заполнение формы данными
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("John");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Doe");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("johndoe@example.com");

        WebElement genderMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        genderMale.click();

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("1234567890");

        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.click();

        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText("July");

        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("1990");

        WebElement day = driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--018']"));
        day.click();

        WebElement subject = driver.findElement(By.id("subjectsInput"));
        subject.sendKeys("Maths");
        //subject.click();
        subject.sendKeys(org.openqa.selenium.Keys.ENTER);

//        WebElement dropdown = driver.findElement(By.id("subjectsInput"));
//        dropdown.click();

        // Выбор опции из выпадающего списка
//        WebElement option = driver.findElement(By.xpath("//a[contains(text(),'Maths')]"));
//        option.click();

        WebElement hobbiesMusic = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        hobbiesMusic.click();

        WebElement address = driver.findElement(By.id("currentAddress"));
        address.sendKeys("123 Main Street");

//        WebElement state = driver.findElement(By.id("state"));
//        state.click();
//        WebElement stateValue = driver.findElement(By.xpath("//div[contains(text(),'Rajasthan')]"));
//        //stateValue.click();
//        stateValue.sendKeys(org.openqa.selenium.Keys.ENTER);

        WebElement dropdown = driver.findElement(By.id("state"));
        dropdown.click();

         //Выбор опции из выпадающего списка
        //WebElement option = driver.findElement(By.xpath("//a[contains(text(),'Haryana')]"));
        WebElement option = driver.findElement(By.xpath("//div[contains(text(),'Rajasthan')]"));
        option.click();
        option.sendKeys(org.openqa.selenium.Keys.ENTER);

        WebElement city = driver.findElement(By.id("city"));
        city.click();
        WebElement cityValue = driver.findElement(By.xpath("//div[contains(text(),'Jaipur')]"));
        cityValue.click();

        // Нажатие на кнопку Submit
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Проверка текста на странице
        WebElement successMessage = driver.findElement(By.className("modal-header"));
        String expectedMessage = "Thanks for submitting the form";
        String actualMessage = successMessage.getText();

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        // Закрытие браузера
        driver.close();
    }
}

