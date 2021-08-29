package pages1;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class BookingGetPage {
    
    WebDriver driver = Driver.getWebDriver();
    
    public String getCSSValue(String element, String valueCss) {
        return Color.fromString(driver.findElement(By.xpath(element)).getCssValue(valueCss)).asHex();
    }
    
    public Integer getTextInteger(String element) {
        return Integer.parseInt(driver.findElement(By.xpath(element)).getText().replaceAll("\\D+", ""));
    }
    
    public String moveToElement(String element) {
        WebElement move = driver.findElement(By.xpath(element));
        Actions make = new Actions(driver);
        make
                .moveToElement(move)
                .perform();
        return move.getAttribute("data-tooltip-text");
    }
}
