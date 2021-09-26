package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import pages.TrashmailPage;

public class BookingJSPage {
    
    private WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER =
            LogManager.getLogger(TrashmailPage.class.getName());
    private static final String SCROLL_ELEMENT_XPATH = "//div[@id='hotellist_inner']/div[10]";
    private static final String SCROLL_INTO_VIEW = "arguments[0].scrollIntoView(true)";
    private static final String BACKGROUND_GREEN_COLOR = "arguments[0].style.backgroundColor = 'green'";
    private static final String STYLE_RED_COLOR = "arguments[0].style.color = 'red'";
    private static final String ARGUMENT_CLICK = "arguments[0].click()";
    
    
    public String getColorElement(String color) {
        WebElement element = driver.findElement(By.xpath(SCROLL_ELEMENT_XPATH));
        ((JavascriptExecutor) driver).executeScript(SCROLL_INTO_VIEW, element);
        ((JavascriptExecutor) driver).executeScript(BACKGROUND_GREEN_COLOR, element);
        ((JavascriptExecutor) driver).executeScript(STYLE_RED_COLOR, element);
        ((JavascriptExecutor) driver).executeScript(ARGUMENT_CLICK, element);
        String colorElement = Color.fromString(driver.findElement(By.xpath(SCROLL_ELEMENT_XPATH)).getCssValue(color)).asHex();
        LOGGER.info(colorElement);
        return colorElement;
        
    }
}