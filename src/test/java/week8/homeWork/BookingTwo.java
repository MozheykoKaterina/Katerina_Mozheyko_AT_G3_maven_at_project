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
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BookingTwo {

    WebDriver driver;
    Wait<WebDriver> wait;

    @Before
    public void doBefore() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
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

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebElement closeMap = wait.until(x -> x.findElement(By.xpath("//div[@aria-label='Close map']")));
        closeMap.click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebElement lowStars = wait.until(x -> x.findElement(By.xpath("//div[@id='filterbox_options']/div/div[@id='filter_review'][1]/div[2]/a[@data-id='review_score-90']")));
        lowStars.click();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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

