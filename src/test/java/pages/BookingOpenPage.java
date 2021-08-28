package pages;

import driver.Driver;
import org.openqa.selenium.WebDriver;

public class BookingOpenPage {
    
    WebDriver driver = Driver.getWebDriver();
    
    public void openBooking() {
        driver.get("https://booking.com");
    }
}
