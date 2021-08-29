package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Calendar;

public class BookingTravelPage {
    
    WebDriver driver = Driver.getWebDriver();
    
    private static final String DIRECTION_XPATH = "//input[@aria-label='Пожалуйста, введите направление.']";
    private static final String CALENDAR_XPATH = "//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']";
    private static final String DATE_FROM_XPATH = "//td[@data-date='%s']";
    private static final String DATE_TO_XPATH = "//td[@data-date='%s']";
    private static final String BUTTON_SEARCH_XPATH = "//button[@class='sb-searchbox__button ']";
    
    public void directionOfTravel(String direction) {
        WebElement element = driver.findElement(By.xpath(DIRECTION_XPATH));
        element.click();
        element.sendKeys(direction);
    }
    
    public void setDateFromTo(int dateFrom, int dateTo ) {
        driver.findElement(By.xpath(CALENDAR_XPATH)).click();
        driver.findElement(By.xpath(String.format(DATE_FROM_XPATH, Calendar.inputDate(dateFrom)))).click();
        driver.findElement(By.xpath(String.format(DATE_TO_XPATH, Calendar.inputDate(dateTo)))).click();
    }
    
    public void search() {
        driver.findElement(By.xpath(BUTTON_SEARCH_XPATH)).click();
    }
}
