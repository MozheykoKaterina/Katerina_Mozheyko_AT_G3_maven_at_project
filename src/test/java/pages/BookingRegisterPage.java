package pages;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import settings.L4JLogging;

public class BookingRegisterPage {
    
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER =
            Logger.getLogger(L4JLogging.class.getName());
    
    private static final String BUTTON_REGISTER_XPATH = "//span[contains(.,'Зарегистрироваться')]";
    private static final String BUTTON_LOGIN_XPATH = "//span[contains(.,'Войти в аккаунт')]";
    private static final String ENTER_MAIL_XPATH = "//input[@id='username']";
    private static final String BUTTON_CONTINUE_XPATH = "//span[contains(.,'Продолжить через электронную почту')]";
    private static final String ENTER_NEW_PASSWORD_XPATH = "//input[@id='new_password']";
    private static final String ENTER_CONFIRM_PASSWORD_XPATH = "//input[@id='confirmed_password']";
    private static final String ENTER_PASSWORD_XPATH = "//input[@id='password']";
    private static final String BUTTON_ENTER_XPATH = "//span[contains(.,'Войти')]";
    private static final String BUTTON_CREATE_ACCOUNT_XPATH = "//span[contains(.,'Создать аккаунт')]";
    private static final String BUTTON_START_SEARCH_XPATH = "//span[contains(.,'Начать поиск')]";
    
    
    public void register(String user, String password) {
        driver.get("https://booking.com");
        driver.findElement(By.xpath(BUTTON_REGISTER_XPATH)).click();
        WebElement email = driver.findElement(By.xpath(ENTER_MAIL_XPATH));
        email.click();
        email.sendKeys(user);
        driver.findElement(By.xpath(BUTTON_CONTINUE_XPATH)).click();
        WebElement newPassword = driver.findElement(By.xpath(ENTER_NEW_PASSWORD_XPATH));
        newPassword.click();
        newPassword.sendKeys(password);
        WebElement confirmPassword = driver.findElement(By.xpath(ENTER_CONFIRM_PASSWORD_XPATH));
        confirmPassword.click();
        confirmPassword.sendKeys(password);
        driver.findElement(By.xpath(BUTTON_CREATE_ACCOUNT_XPATH)).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions make = new Actions(driver);
        make
                .sendKeys(Keys.TAB)
                .clickAndHold()
                .build()
                .perform();
        driver.findElement(By.xpath(BUTTON_START_SEARCH_XPATH)).click();
        LOGGER.info("Registration successful");
    }
    
    public void login(String user, String password) {
        driver.get("https://booking.com");
        driver.findElement(By.xpath(BUTTON_LOGIN_XPATH)).click();
        WebElement email = driver.findElement(By.xpath(ENTER_MAIL_XPATH));
        email.click();
        email.sendKeys(user);
        driver.findElement(By.xpath(BUTTON_CONTINUE_XPATH)).click();
        WebElement newPassword = driver.findElement(By.xpath(ENTER_PASSWORD_XPATH));
        newPassword.click();
        newPassword.sendKeys(password);
        driver.findElement(By.xpath(BUTTON_ENTER_XPATH)).click();
        LOGGER.info("Login successful");
    }
}