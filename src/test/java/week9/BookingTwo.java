package week9;

import org.junit.*;
import org.openqa.selenium.WebDriver;

public class BookingTwo {

    WebDriver driver;

    @Before
    public void doBefore() {
        driver = Driver.getWebDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void checkBooking() {
        driver.get("https://demoqa.com/select-menu");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "ToolsQA");
    }

    @Test
    public void checkTutorial() {
        driver.get("https://www.booking.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Booking.com | Официальный сайт | Лучшие отели и другое жилье");
    }
}