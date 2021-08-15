package week9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public static WebDriver getDriver(Config config)  {
        return switch (config) {
            case FIREFOX -> new FirefoxDriver();
            case EDGE -> new EdgeDriver();
            default -> new ChromeDriver();
        };
    }
}
