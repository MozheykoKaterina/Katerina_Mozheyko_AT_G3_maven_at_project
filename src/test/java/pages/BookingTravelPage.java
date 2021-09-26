package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Calendar;

public class BookingTravelPage {
    
    private WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER =
            LogManager.getLogger(BookingTravelPage.class.getName());
    private static final String DIRECTION_XPATH = "//input[@aria-label='Пожалуйста, введите направление.']";
    private static final String CALENDAR_XPATH = "//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']";
    private static final String DATE_FROM_XPATH = "//td[@data-date='%s']";
    private static final String DATE_TO_XPATH = "//td[@data-date='%s']";
    private static final String BUTTON_SEARCH_XPATH = "//button[@class='sb-searchbox__button ']";
    private static final String CURRENCY_XPATH = "//nav/div[2]/div/button[@data-tooltip-text='Выберите валюту']";
    private static final String LANGUAGE_XPATH = "//nav/div[2]/div/button[@data-tooltip-text='Выберите язык']";
    private static final String TOOLTIPS_ATTRIBUTE = "data-tooltip-text";
    
    public void directionOfTravel(String direction) {
        driver.findElement(By.xpath(DIRECTION_XPATH)).sendKeys(direction);
    }
    
    public void setDateFromTo(int dateFrom, int dateTo ) {
        driver.findElement(By.xpath(CALENDAR_XPATH)).click();
        driver.findElement(By.xpath(String.format(DATE_FROM_XPATH, Calendar.inputDate(dateFrom)))).click();
        driver.findElement(By.xpath(String.format(DATE_TO_XPATH, Calendar.inputDate(dateTo)))).click();
    }
    
    public void startSearch() {
        driver.findElement(By.xpath(BUTTON_SEARCH_XPATH)).click();
    }
    
    public String getValueTooltips(String element) {
        WebElement move;
        if (element == "currency") {
            move = driver.findElement(By.xpath(CURRENCY_XPATH));
        } else if (element == "language") {
            move = driver.findElement(By.xpath(LANGUAGE_XPATH));
        } else {
            return null;
        }
        Actions make = new Actions(driver);
        make
                .moveToElement(move)
                .perform();
        String valueAttribute = move.getAttribute(TOOLTIPS_ATTRIBUTE);
        LOGGER.info(valueAttribute);
        return valueAttribute;
    }
}
