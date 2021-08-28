package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BookingFilterPage {
    
    WebDriver driver = Driver.getWebDriver();
    
    public void filterBooking() {
        driver.findElement(By.xpath("//div[@id='filterbox_options']/div/div[@id='filter_review'][1]/div[2]/a[@data-id='review_score-90']")).click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));
    
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
