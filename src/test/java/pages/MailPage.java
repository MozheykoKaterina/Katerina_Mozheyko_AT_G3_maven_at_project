package pages;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import settings.L4JLogging;

public class MailPage {
    
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER =
            Logger.getLogger(L4JLogging.class.getName());
    
    String mailTrashmail;
    private static final String NAME_OF_BOX_XPATH = "//input[@name='login']";
    private static final String BUTTON_ENTER_PASSWORD_XPATH = "//button[@data-testid='enter-password']";
    private static final String ENTER_PASSWORD_XPATH = "//input[@data-testid='password-input']";
    private static final String CONFIRM_XPATH = "//button[@data-testid='login-to-mail']";
    private static final String LAST_LETTER_XPATH = "//div[@class='dataset__items']/a[1]";
    public static final String TRASHMAIL = "//div[@class='html-expander']/div/div/div/a[1]";
    public static final String BOOKING = "//a[contains(.,'Подтверждаю')]";
    
    
    private void loginByMail(String user, String password) {
        driver.get("https://mail.ru/");
        WebElement login = driver.findElement(By.xpath(NAME_OF_BOX_XPATH));
        login.click();
        login.sendKeys(user);
        driver.findElement(By.xpath(BUTTON_ENTER_PASSWORD_XPATH)).click();
        WebElement pass = driver.findElement(By.xpath(ENTER_PASSWORD_XPATH));
        pass.click();
        pass.sendKeys(password);
        driver.findElement(By.xpath(CONFIRM_XPATH)).click();
        driver.findElement(By.xpath(LAST_LETTER_XPATH)).click();
    }
    
    public String confirmRegister(String user, String password, String site) {
        loginByMail(user, password);
        WebElement reg = driver.findElement(By.xpath(site));
        String confirm = reg.getText();
        reg.click();
        LOGGER.info(confirm);
        return confirm;
    }
}