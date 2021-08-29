package pages;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.L4JLogging;

public class BookingHotelPage {
    
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER =
            Logger.getLogger(L4JLogging.class.getName());
    
    private static final String FIRST_HOTEL_XPATH = "//div[@id='hotellist_inner']/div[1]/div/div/button[@data-title='Сохранить']";
    private static final String LAST_HOTEL_XPATH = "//div[@id='hotellist_inner']/div[last()]/div/div/button[@data-title='Сохранить']";
    private static final String ACCOUNT_XPATH = "//span[@id='profile-menu-trigger--title']";
    private static final String SAVE_HOTEL = "//span[contains(.,'Сохраненное')]";
    private static final String LIST_SAVE_HOTEL = "//img[@class='bui-card__image js-listview-book js-listview-hotel-image']";
    
    public int saveFavorites() {
        driver.findElement(By.xpath(FIRST_HOTEL_XPATH)).click();
        driver.findElement(By.xpath(LAST_HOTEL_XPATH)).click();
        driver.findElement(By.xpath(ACCOUNT_XPATH)).click();
        driver.findElement(By.xpath(SAVE_HOTEL)).click();
        LOGGER.info("Count favorites " + driver.findElements(By.xpath(LIST_SAVE_HOTEL)).size());
        return driver.findElements(By.xpath(LIST_SAVE_HOTEL)).size();
    }
}