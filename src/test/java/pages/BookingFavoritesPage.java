package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.Calendar;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BookingFavoritesPage {
    
    WebDriver driver = Driver.getWebDriver();
    LogonPage logon = new LogonPage();
    
    public void login() {
        logon.logon(); System.out.println(logon.getLogin());
    }
    
    public void getUrl(String element) {
        driver.get(element);
    }
    
    public void clickElement(String element) {
        driver.findElement(By.xpath(element)).click();
    }
    
    public void clickElementWait(String element) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(x -> x.findElement(By.xpath(element))).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
    }
    
    public void inputElement(String element, String input) {
        WebElement inputElement = driver.findElement(By.xpath(element));
        inputElement.sendKeys(input);
        inputElement.click();
    }
    
    public void inputDate(String element, int datePlus) {
        Calendar.inputDate(datePlus);
        driver.findElement(By.xpath(String.format(element, Calendar.inputDate(datePlus)))).click();
    }
    
    public void clickRegister(String element, String password) throws InterruptedException {
        WebElement user = driver.findElement(By.xpath(element));
        user.click();
        user.sendKeys("alexis57@my10minutemail.com");
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
        System.out.println("222");
    }
    
    public Integer isElementPresent(String element) {
        return driver.findElements(By.xpath(element)).size();
    }
    
    public boolean isVisible(String element) {
        try {
            driver.findElement(By.xpath(element));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}