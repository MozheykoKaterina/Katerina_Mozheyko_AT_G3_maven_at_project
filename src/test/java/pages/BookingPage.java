package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.Calendar;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BookingPage {
    
    WebDriver driver = Driver.getWebDriver();
    
    public void getUrl(String element) {
        driver.get(element);
    }
    
    public void clickElement(String element) {
        driver.findElement(By.xpath(element)).click();
    }
    
    public void spinnerWait(String element) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(element)));
    
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    
    public void inputElement(String element, String input) {
        WebElement inputElement = driver.findElement(By.xpath(element)); inputElement.sendKeys(input);
        inputElement.click();
    }
    
    public void findElement(String element) {
        driver.findElement(By.xpath(element));
    }
    
    public void clickElementWait(String element) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(x -> x.findElement(By.xpath(element))).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    
    public void javascriptExecutor(String element, String arguments) {
        WebElement argument = driver.findElement(By.xpath(element));
        ((JavascriptExecutor) driver).executeScript(arguments, argument);
    }
    
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
    
    public void inputDate(String element, int datePlus) {
        Calendar.inputDate(datePlus);
        driver.findElement(By.xpath(String.format(element, Calendar.inputDate(datePlus)))).click();
    }
    
    public void closeMap(String element) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(x -> x.findElement(By.xpath(element))).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}