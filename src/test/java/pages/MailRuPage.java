package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.UserForBooking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class MailRuPage {
    
    private WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER =
            LogManager.getLogger(MailRuPage.class.getName());
    private static final String NAME_OF_BOX_XPATH = "//input[@name='login']";
    private static final String BUTTON_ENTER_PASSWORD_XPATH = "//button[@data-testid='enter-password']";
    private static final String ENTER_PASSWORD_XPATH = "//input[@data-testid='password-input']";
    private static final String CONFIRM_XPATH = "//button[@data-testid='login-to-mail']";
    private static final String LAST_LETTER_XPATH = "//div[@class='dataset__items']/a[1]";
    public static final String TRASHMAIL = "//div[@class='html-expander']/div/div/div/a[1]";
    public static final String BOOKING = "//a[contains(.,'Подтверждаю')]";
    public static final String BOOKING_CONFIRM_XPATH = "//h1";
    
    
    private void loginByMail(String user, String password) {
        driver.get("https://mail.ru/");
        driver.findElement(By.xpath(NAME_OF_BOX_XPATH)).sendKeys(user);
        driver.findElement(By.xpath(BUTTON_ENTER_PASSWORD_XPATH)).click();
        driver.findElement(By.xpath(ENTER_PASSWORD_XPATH)).sendKeys(password);
        driver.findElement(By.xpath(CONFIRM_XPATH)).click();
        driver.findElement(By.xpath(LAST_LETTER_XPATH)).click();
    }
    
    public String confirmRegister(String user, String password, String site) {
        loginByMail(user, password);
        if (site == "booking") {
            driver.findElement(By.xpath(BOOKING)).click();
            Set<String> handles = driver.getWindowHandles();
            Iterator<String> itr = handles.iterator();
            String parentWindow = itr.next();
            String newWindow = itr.next();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.switchTo().window(newWindow);
            String confirmRegSite = driver.findElement(By.xpath(BOOKING_CONFIRM_XPATH)).getText();
            LOGGER.info(confirmRegSite);
            driver.close();
            driver.switchTo().window(parentWindow);
            return confirmRegSite;
        } else if (site == "trashmail") {
            WebElement confirm = driver.findElement(By.xpath(TRASHMAIL));
            confirm.click();
            String confirmRegSite = confirm.getText();
            LOGGER.info(confirmRegSite);
            return confirmRegSite;
        }
        return null;
    }
}