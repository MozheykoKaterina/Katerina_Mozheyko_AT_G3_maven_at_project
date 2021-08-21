package steps;

import driver.Driver;
import org.junit.AfterClass;

public class BaseSteps {
    
    @AfterClass
    public static void closeDriver() {
        Driver.destroy();
    }
}