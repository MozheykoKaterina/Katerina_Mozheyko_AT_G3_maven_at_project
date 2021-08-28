package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;
    ChromeOptions options = new ChromeOptions();

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = DriverManager.getDriver(Config.CHROME);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void initDriver(Config config) {
        if (driver == null) {
            driver = DriverManager.getDriver(config);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }
    
    public static void close() {
        driver.close();
    }

    public static void destroy() {
        driver.close();
        driver.quit();
        driver = null;
    }
}