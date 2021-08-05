package week8.classWork;

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

import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BookingDemo {

    WebDriver driver;
    @Before
    public void doBefore() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
            public void checkBooking() {
        driver.get("https://booking.com");

        WebElement directionSearch = driver.findElement(By.xpath("//input[@aria-label='Пожалуйста, введите направление.']"));
        directionSearch.sendKeys(new CharSequence[]{"Париж"});
        directionSearch.click();

        WebElement directionSearchSubmit = driver.findElement(By.xpath("//ul[@aria-label='Список рекомендуемых направлений']"));
        directionSearchSubmit.click();

        WebElement guests = driver.findElement(By.xpath("//span[@class='xp__guests__count']"));
        guests.click();

        WebElement guestCount = driver.findElement(By.xpath("//button[@aria-label='Взрослых: увеличить количество']/span[contains(.,'+')][1]"));
        guestCount.click();
        guestCount.click();

        WebElement roomCount = driver.findElement(By.xpath("//button[@aria-label='Номера: увеличить количество']/span[contains(.,'+')][1]"));
        roomCount.click();

        WebElement calendar = driver.findElement(By.xpath("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']"));
        calendar.click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +3);
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE, +10);
        Date date1 = cal.getTime();
        String fromdate = dateFormat.format(date1);
        Date date2 = cal2.getTime();
        String todate = dateFormat.format(date2);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement fromDate = driver.findElement(By.xpath(String.format("//td[@data-date='%s']", fromdate)));
        fromDate.click();

        WebElement toDate = driver.findElement(By.xpath(String.format("//td[@data-date='%s']", todate)));
        toDate.click();

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']"));
        searchButton.click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        WebElement lowPrice = driver.findElement(By.xpath("//a[contains(.,'Цена (сначала самая низкая)')]"));
        lowPrice.click();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));

        WebElement maxPrice = driver.findElement(By.xpath("//a[@data-id='pri-5']/label/div/span[contains(.,'+')]"));
        int expectedMaxPrice = Integer.parseInt(maxPrice.getText().replaceAll("\\D+", ""));
        System.out.println("Expected price " + expectedMaxPrice);
        maxPrice.click();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));

        WebElement acPrice = driver.findElement(By.xpath("//div[@id='hotellist_inner']//div[@class='bui-price-display__value prco-inline-block-maker-helper ']"));
        int actualPrice = Integer.parseInt(acPrice.getText().replaceAll("\\D+", ""));
        System.out.println("Actual price " + actualPrice / 7);
        Assert.assertTrue(actualPrice >= expectedMaxPrice);
    }
        @After
                public void after() {
        driver.close();
        driver.quit();
    }
}