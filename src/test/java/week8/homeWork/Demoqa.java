package week8.homeWork;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class Demoqa {

    WebDriver driver;

    @Before
    public void doBefore() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void checkSelectValue() {
        driver.get("https://demoqa.com/select-menu");
        WebElement selectValue = driver.findElement(By.xpath("//div[@class='mt-2 row'][1]/div/div/div[@class=' css-yk16xz-control']"));
        selectValue.click();
        Actions makeValue = new Actions(driver);
        makeValue.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        System.out.println(selectValue.getText());
        Assert.assertEquals("Group 2, option 1", selectValue.getText());

        WebElement selectOne = driver.findElement(By.xpath("//div[@class='mt-2 row'][2]/div/div/div[@class=' css-yk16xz-control']"));
        selectOne.click();
        Actions makeOne = new Actions(driver);
        makeOne.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        System.out.println(selectOne.getText());
        Assert.assertEquals("Mrs.", selectOne.getText());

        WebElement colors = driver.findElement(By.id("oldSelectMenu"));
        Select selectColor = new Select(colors);
        selectColor.selectByValue("3");
        String color = driver.findElement(By.xpath("//select[@id='oldSelectMenu']/option[@value='3']")).getText();
        System.out.println(color);
        Assert.assertEquals("Yellow", color);

        WebElement cars = driver.findElement(By.id("cars"));
        Select selectCars = new Select(cars);
        selectCars.selectByValue("saab");
        String car = driver.findElement(By.xpath("//select[@id='cars']/option[@value='saab']")).getText();
        System.out.println(car);
        Assert.assertEquals("Saab", car);
    }

    @AfterClass
    public void after() {
        driver.close();
        driver.quit();
    }
}