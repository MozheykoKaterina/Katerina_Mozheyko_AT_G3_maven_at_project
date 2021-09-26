package listeners;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
    
    private static final Logger LOGGER =
            LogManager.getLogger(ListenerTest.class.getName());
    
    private String runId = "953";
    
    public void onTestStart(ITestResult result) {
        LOGGER.info("Printing getName: " + result.getName());
        LOGGER.info("Printing getTestName: " + result.getTestName());
        LOGGER.info("Printing getMetod: " + result.getMethod().getDescription());
    }
    
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Printing onSuccess: " + result.getStatus());
        TestRailReporter.reportResult(runId, result.getMethod().getDescription(), new Result(1));
    }
    
    public void onTestFailure(ITestResult result) {
        LOGGER.info("Printing onFailure: " + result.getStatus());
        TestRailReporter.reportResult(runId, result.getMethod().getDescription(), new Result(5));
    }
}