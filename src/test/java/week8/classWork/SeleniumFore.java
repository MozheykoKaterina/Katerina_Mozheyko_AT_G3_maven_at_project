package week8.classWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFore {

    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        driver.get("https://google.com");
        driver.navigate().to("https://ya.ru");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.close();
        driver.quit();
    }
}