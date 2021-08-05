package week8.classWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOne {

    static WebDriver driver = new ChromeDriver(); //default

    public static void main(String[] args) {
        driver.get("https://selenium.dev");
    }
}