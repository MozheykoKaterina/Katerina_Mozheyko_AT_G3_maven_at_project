package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BookingHotelPage;
import utils.WaitSpinner;

public class BookingFilterHotelPage {
    
    private WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER =
            LogManager.getLogger(BookingHotelPage.class.getName());
    private static final String SCORE_9_XPATH = "//div[@id='filterbox_options']/div/div[@id='filter_review'][1]/div[2]/a[@data-id='review_score-90']";
    private static final String SPINNER = ".bui-spinner.bui-spinner--size-large";
    
    public void filterReviewScore() {
        driver.findElement(By.xpath(SCORE_9_XPATH)).click();
        new WaitSpinner().waitSpinner(SPINNER);
    }
}