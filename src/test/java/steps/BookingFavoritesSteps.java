package steps;

import driver.Driver;
import org.junit.AfterClass;

public class BookingFavoritesSteps {
    
    @AfterClass
    public static void closeDriver() {
        Driver.destroy();
    }
}