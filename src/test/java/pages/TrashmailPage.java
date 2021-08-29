package pages;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import settings.L4JLogging;

public class TrashmailPage {
    
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER =
            Logger.getLogger(L4JLogging.class.getName());
    
    String loginTrashmail;
    private static final String CHOOSE_DOMAIN_XPATH = "//button[contains(.,'Choose among the following')]";
    private static final String REAL_ADDRESS_XPATH = "//input[@id='fe-forward']";
    private static final String NUMBER_OF_FORWARDS_XPATH = "//form[@name='tm-login-form']/div[@class='input-group input-group-sm input-group-btn']/div[@class='input-group-btn']";
    private static final String COUNT_LIMIT_XPATH = "//ul[@tabindex='-1']";
    private static final String LIVE_SPAN_XPATH = "//div/div[@class='input-group input-group-sm input-group-btn']/div[@class='input-group-btn']";
    private static final String BUTTON_SUBMIT_XPATH = "//button[@id='fe-submit']";
    private static final String LOGIN_XPATH = "//input[@id='fe-dea']";
    
    public void getLoginTrashmail(String user) {
        driver.get("https://trashmail.com/");
        driver.findElement(By.xpath(CHOOSE_DOMAIN_XPATH)).click();
        Actions make = new Actions(driver);
        make
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        WebElement realEmail = driver.findElement(By.xpath(REAL_ADDRESS_XPATH));
        realEmail.click();
        realEmail.sendKeys(user);
        driver.findElement(By.xpath(NUMBER_OF_FORWARDS_XPATH)).click();
        driver.findElement(By.xpath(COUNT_LIMIT_XPATH)).click();
        driver.findElement(By.xpath(LIVE_SPAN_XPATH)).click();
        driver.findElement(By.xpath(COUNT_LIMIT_XPATH)).click();
        driver.findElement(By.xpath(BUTTON_SUBMIT_XPATH)).click();
        loginTrashmail = driver.findElement(By.xpath(LOGIN_XPATH)).getAttribute("value");
        LOGGER.info(loginTrashmail);
    }
    
    public String getLogin() {
        return loginTrashmail;
    }
}
