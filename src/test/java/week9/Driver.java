package week9;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = DriverManager.getDriver(Config.CHROME);
            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        }
        return webDriver;
    }

    public static void initDriver(Config config) {
        if (webDriver == null) {
            webDriver = DriverManager.getDriver(config);
        }
    }

    public static void destroy() {
        webDriver.close();
        webDriver.quit();
        webDriver = null;
    }
}