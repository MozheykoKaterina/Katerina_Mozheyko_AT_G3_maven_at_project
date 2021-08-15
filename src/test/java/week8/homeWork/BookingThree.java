package week8.homeWork;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BookingThree {

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
        directionSearch.sendKeys("Москва");
        directionSearch.click();

        WebElement calendar = driver.findElement(By.xpath("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']"));
        calendar.click();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +1);
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE, +4);
        Date date1 = cal.getTime();
        String fromdate = dateFormat.format(date1);
        Date date2 = cal2.getTime();
        String todate = dateFormat.format(date2);

        WebElement fromDate = driver.findElement(By.xpath(String.format("//td[@data-date='%s']", fromdate)));
        fromDate.click();

        WebElement toDate = driver.findElement(By.xpath(String.format("//td[@data-date='%s']", todate)));
        toDate.click();

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']"));
        searchButton.click();

        WebElement count = driver.findElement(By.xpath("//h1[contains(.,'Москва')]"));
        int countVar = Integer.parseInt(count.getText().replaceAll("\\D+", ""));
        System.out.println("Найдено " + countVar + " варианта");
        Assert.assertTrue(countVar > 0);
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }
}
