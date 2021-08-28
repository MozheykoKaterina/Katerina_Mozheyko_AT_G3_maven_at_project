package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingJSPage {
    
    WebDriver driver = Driver.getWebDriver();
    
    public void javascriptExecutor(String element, String arguments) {
        WebElement argument = driver.findElement(By.xpath(element));
        ((JavascriptExecutor) driver).executeScript(arguments, argument);
    }
    
    
}