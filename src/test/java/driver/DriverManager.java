package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    public static WebDriver getDriver(Config config)  {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--incognito");
        options.addArguments("--disable-site-security");
        return switch (config) {
            case FIREFOX -> new FirefoxDriver();
            case EDGE -> new EdgeDriver();
            case REMOTE -> getRemoteDriver();
            default -> new ChromeDriver(options);
        };
    }
    
    private static WebDriver getRemoteDriver() {
        System.out.println("start remote webdriver");
        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver webDriver = null;
        try {
            webDriver = new RemoteWebDriver(new URL("http:/localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return webDriver;
    }
}