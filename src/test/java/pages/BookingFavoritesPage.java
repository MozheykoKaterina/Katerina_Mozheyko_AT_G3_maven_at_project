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
    
    public void clickElementWait(String element) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(x -> x.findElement(By.xpath(element))).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
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