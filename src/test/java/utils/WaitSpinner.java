package utils;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WaitSpinner {
    
    private WebDriver driver = Driver.getWebDriver();
    
    public void waitSpinner(String element) {
    
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(element)));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}