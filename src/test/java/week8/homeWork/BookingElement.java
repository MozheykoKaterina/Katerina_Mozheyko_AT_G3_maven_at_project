package week8.homeWork;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class BookingElement {

    WebDriver driver;

    @Before
    public void doBefore() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void chekBooking() {
        driver.get("https://www.booking.com");
        WebElement currency = driver.findElement(By.xpath("//nav/div[2]/div/button[@data-tooltip-text='Выберите валюту']"));
        Actions make = new Actions(driver);
        make.moveToElement(currency).perform();
        String cur = currency.getAttribute("data-tooltip-text");
        System.out.println("Currency hint value " + cur);
        WebElement language = driver.findElement(By.xpath("//nav/div[2]/div/button[@data-tooltip-text='Выберите язык']"));
        make.moveToElement(language).perform();
        String lang = language.getAttribute("data-tooltip-text");
        System.out.println("Language hint value " + lang);
        Assert.assertEquals("Currency hint value" , "Выберите валюту", cur);
        Assert.assertEquals("Language hint value" , "Выберите язык", lang);
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }
}