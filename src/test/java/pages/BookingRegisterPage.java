package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BookingRegisterPage {
    
    WebDriver driver = Driver.getWebDriver();
    
    public void registerBooking(String user, String password) throws InterruptedException {
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//span[contains(.,'Зарегистрироваться')]")).click();
        WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
        email.click();
        email.sendKeys(user);
        driver.findElement(By.xpath("//span[contains(.,'Продолжить через электронную почту')]")).click();
        WebElement newPassword = driver.findElement(By.xpath("//input[@id='new_password']"));
        newPassword.click();
        newPassword.sendKeys(password);
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='confirmed_password']"));
        confirmPassword.click();
        confirmPassword.sendKeys(password);
        driver.findElement(By.xpath("//span[contains(.,'Создать аккаунт')]")).click();
        Thread.sleep(1500);
        Actions make = new Actions(driver);
        make
                .sendKeys(Keys.TAB)
                .clickAndHold()
                .build()
                .perform();
        driver.findElement(By.xpath("//span[contains(.,'Начать поиск')]")).click();
    }
    
    public String confirmRegisterBooking() throws InterruptedException {
        driver.get("https://mail.ru/");
        WebElement login = driver.findElement(By.xpath("//input[@name='login']"));
        login.click();
        login.sendKeys("katik010489");
        driver.findElement(By.xpath("//button[@data-testid='enter-password']")).click();
        WebElement password = driver.findElement(By.xpath("//input[@data-testid='password-input']"));
        password.click();
        password.sendKeys("7741693Bolik");
        driver.findElement(By.xpath("//button[@data-testid='login-to-mail']")).click();
        driver.findElement(By.xpath("//div[@class='llc__content']/div/span[contains(.,'Booking.com')]")).click();
        driver.findElement(By.xpath("//a[contains(.,'Подтверждаю')]")).click();
        WebElement confirm = driver.findElement(By.xpath("//h1"));
        System.out.println("Вижу текст: " + confirm.getText());
        return confirm.getText();
    }
}