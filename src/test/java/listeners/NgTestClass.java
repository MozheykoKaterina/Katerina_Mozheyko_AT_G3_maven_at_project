package listeners;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerTest.class)
public class NgTestClass {
    
    private static final Logger LOGGER =
            LogManager.getLogger(NgTestClass.class.getName());
    
    @Test(description = "94311")
    public void firstTest() {
        LOGGER.info("Execution One");
        Assert.assertTrue(true);
    }
    
    @Test(description = "94312")
    public void secondTest() {
        LOGGER.info("Execution Two");
        Assert.assertTrue(false);
    }
}