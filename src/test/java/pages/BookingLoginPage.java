package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingLoginPage {
    
    WebDriver driver = Driver.getWebDriver();
    
    public void loginBooking(String user, String password) {
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//span[contains(.,'Войти в аккаунт')]")).click();
        WebElement inputElement = driver.findElement(By.xpath("//input[@id='username']"));
        inputElement.sendKeys(user);
        inputElement.click();
        driver.findElement(By.xpath("//span[contains(.,'Продолжить')]")).click();
        WebElement newPassword = driver.findElement(By.xpath("//input[@id='password']"));
        newPassword.click();
        newPassword.sendKeys(password);
        driver.findElement(By.xpath("//span[contains(.,'Войти')]")).click();
    }
}