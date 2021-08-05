package week8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Booking {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://booking.com");
        WebElement el = driver.findElement(By.xpath("//input[@aria-label='Пожалуйста, введите направление.']"));
        el.sendKeys("Париж");
        el.click();
        WebElement el1 = driver.findElement(By.xpath("//ul[@aria-label='Список рекомендуемых направлений']"));
        el1.click();
        WebElement el2 = driver.findElement(By.xpath("//span[@class='xp__guests__count']"));
        el2.click();
        WebElement el3 = driver.findElement(By.xpath("//button[@aria-label='Взрослых: увеличить количество']/span[contains(.,'+')][1]"));
        el3.click();
        el3.click();
        WebElement el4 = driver.findElement(By.xpath("//button[@aria-label='Номера: увеличить количество']/span[contains(.,'+')][1]"));
        el4.click();
        WebElement el5 = driver.findElement(By.xpath("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']"));
        el5.click();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +3);
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE, +10);
        Date date1 = cal.getTime();
        String fromdate = dateFormat.format(date1);
        System.out.println(fromdate);
        Date date2 = cal2.getTime();
        String todate = dateFormat.format(date2);
        System.out.println(todate);
        System.out.println(String.format(fromdate, "//td[@data-date='%s']"));
        WebElement el6 = driver.findElement(By.xpath(String.format("//td[@data-date='%s']", fromdate)));
        el6.click();
        WebElement el7 = driver.findElement(By.xpath(String.format("//td[@data-date='%s']", todate)));
        el7.click();
        WebElement el8 = driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']"));
        el8.click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebElement el9 = driver.findElement(By.xpath("//a[contains(.,'Цена (сначала самая низкая)')]"));
        el9.click();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));

        WebElement el10 = driver.findElement(By.xpath("//a[@data-id='pri-5']/label/div/span[contains(.,'+')]"));
        int expectedMaxPrice = Integer.parseInt(el10.getText().replaceAll("\\D+", ""));
        System.out.println("Expected price " + expectedMaxPrice);
        el10.click();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));

        WebElement el11 = driver.findElement(By.xpath("//div[@id='hotellist_inner']//div[@class='bui-price-display__value prco-inline-block-maker-helper ']"));
        int actualPrice = Integer.parseInt(el11.getText().replaceAll("\\D+", ""));
        System.out.println("Actual price " + actualPrice / 7);
        driver.close();
        driver.quit();
    }
}