package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingHotelPage {
    
    private WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER =
            LogManager.getLogger(BookingHotelPage.class.getName());
    private static final String FIRST_HOTEL_XPATH = "//div[@id='hotellist_inner']/div[1]/div/div/button[@data-title='Сохранить']";
    private static final String LAST_HOTEL_XPATH = "//div[@id='hotellist_inner']/div[last()]/div/div/button[@data-title='Сохранить']";
    private static final String ACCOUNT_XPATH = "//span[@id='profile-menu-trigger--title']";
    private static final String SAVE_HOTEL = "//span[contains(.,'Сохраненное')]";
    private static final String LIST_SAVE_HOTEL = "//img[@class='bui-card__image js-listview-book js-listview-hotel-image']";
    private static final String COUNT_VARIABLE_XPATH = "//h1";
    private static final String RAITING_XPATH = "//div[@id='hotellist_inner']//div[@class='bui-review-score__badge']";
    
    public int getCountSaveFavorites() {
        driver.findElement(By.xpath(FIRST_HOTEL_XPATH)).click();
        driver.findElement(By.xpath(LAST_HOTEL_XPATH)).click();
        driver.findElement(By.xpath(ACCOUNT_XPATH)).click();
        driver.findElement(By.xpath(SAVE_HOTEL)).click();
        int countSaveHotel = driver.findElements(By.xpath(LIST_SAVE_HOTEL)).size();
        LOGGER.info("Count favorites " + countSaveHotel);
        return countSaveHotel;
    }
    
    public int getCountVariable() {
        int countVariable = Integer.parseInt(driver.findElement(By.xpath(COUNT_VARIABLE_XPATH)).getText()
                .replaceAll("\\D+", ""));
        LOGGER.info("Count variable :" + countVariable);
        return countVariable;
    }
    
    public double getRaiting() {
        double raiting = Integer.parseInt(driver.findElement(By.xpath(RAITING_XPATH)).getText()
                .replaceAll("\\D+", ""));
        LOGGER.info("Raiting hotel " + raiting);
        return raiting / 10;
    }
}