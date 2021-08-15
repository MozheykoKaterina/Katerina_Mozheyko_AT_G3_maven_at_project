package week8.homeWork;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.util.concurrent.TimeUnit;

public class Booking {

    WebDriver driver;

    @Before
    public void doBefore() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void checkBooking() {
        driver.get("https://www.booking.com");
        WebElement directionSearch = driver.findElement(By.xpath("//input[@aria-label='Пожалуйста, введите направление.']"));
        directionSearch.sendKeys("Москва");
        directionSearch.click();
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']"));
        searchButton.click();
        WebElement hotel = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[10]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", hotel);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'green'", hotel);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", hotel);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", hotel);
        String color = hotel.getCssValue("color");
        String hexColor = Color.fromString(color).asHex();
        System.out.println(hexColor);
        Assert.assertEquals("Color", "#ff0000", hexColor);
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }
}