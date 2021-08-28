package steps;

import driver.Config;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FakeBaseSteps {
    
    private static final Logger LOGGER  = LogManager.getLogger(FakeBaseSteps.class);
    
    @Before
    public void beforeTest() {
        System.out.println("Before");
        LOGGER.info("Initializing WebDriver");
        //Driver.initDriver(Config.CHROME);
        Driver.initDriver(Config.CHROME);
    }
    
    @After
    public void afterTest() {
        System.out.println("After");
        LOGGER.info("Killing");
        Driver.destroy();
    }
}
