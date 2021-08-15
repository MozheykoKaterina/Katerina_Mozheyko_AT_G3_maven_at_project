package week8.homeWork;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class W3schools {

    WebDriver driver;
    Wait<WebDriver> wait;

    @Before
    public void doBefore() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

    @Test
    public void checkW3schools() {
        driver.get("https://www.w3schools.com/java/");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebElement tutorial = wait.until(x -> x.findElement(By.xpath("//span[contains(.,'Tutorial')]")));
        System.out.println(tutorial.getText());
        Actions make = new Actions(driver);
        make.doubleClick(tutorial);
        make.keyDown(Keys.CONTROL + "c").keyUp(Keys.CONTROL + "c").perform();
        driver.get("https://www.google.com");
        WebElement search = driver.findElement(By.xpath("//input[@title='Поиск']"));
        search.click();
        make.keyDown(Keys.CONTROL + "v").keyUp(Keys.CONTROL + "v").keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        WebElement getValue = driver.findElement(By.xpath("gLFyf gsfi"));
        System.out.println(getValue.getText());
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }
}