package week8.homeWork;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BookingTwo {

    WebDriver driver;

    @Before
    public void doBefore() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void checkBooking() {
        driver.get("https://booking.com");

        WebElement directionSearch = driver.findElement(By.xpath("//input[@aria-label='Пожалуйста, введите направление.']"));
        directionSearch.sendKeys("Москва");
        directionSearch.click();

        WebElement directionSearchSubmit = driver.findElement(By.xpath("//ul[@aria-label='Список рекомендуемых направлений']"));
        directionSearchSubmit.click();

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']"));
        searchButton.click();

        WebElement closeMap = driver.findElement(By.xpath("//div[@aria-label='Close map']"));
        closeMap.click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebElement lowStars = driver.findElement(By.xpath("//a[@data-id='review_score-90']/label/div/span[contains(., 'Превосходно')]"));
        lowStars.click();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));

        WebElement acStars = driver.findElement(By.xpath("//div[@id='hotellist_inner']//div[@class='bui-review-score__badge']"));
        double actualStars = Integer.parseInt(acStars.getText().replaceAll("\\D+", ""));
        System.out.println("Актуальный рейтинг  " + actualStars / 10);
        Assert.assertTrue(actualStars >= 9);
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }
}

