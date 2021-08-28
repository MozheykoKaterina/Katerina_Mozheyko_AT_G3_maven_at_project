package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Calendar;

public class BookingTravelPage {
    
    WebDriver driver = Driver.getWebDriver();
    
    public void travel(String city) {
        WebElement element = driver.findElement(By.xpath("//input[@aria-label='Пожалуйста, введите направление.']"));
        element.click();
        element.sendKeys(city);
    }
    
    public void calendar(int dateFrom, int dateTo ) {
        WebElement cal = driver.findElement(By.xpath("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']"));
        cal.click();
        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", Calendar.inputDate(dateFrom)))).click();
        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", Calendar.inputDate(dateTo)))).click();
    }
    
    public void search() {
        driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();
    }
}
