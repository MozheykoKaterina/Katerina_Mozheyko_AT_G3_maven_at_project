package week8.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Demoqa {

    static WebDriver driver = new ChromeDriver();


    public static void main(String[] args) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        WebElement elements = driver.findElement(By.xpath("//span[contains(., 'Elements')]"));
        elements.click();
        WebElement checkBox = driver.findElement(By.xpath("//span[contains(., 'Check Box')]"));
        checkBox.click();
        WebElement home = driver.findElement(By.xpath("//ol/li/span/button[@title='Toggle']"));
        home.click();
        Select select = new Select(home);
        select.selectByVisibleText("Desktop");

        //WebElement forms = driver.findElement(By.xpath("//div[@class='left-pannel']/div/div[@class='element-group'][2]"));
        //forms.click();
        //Select select1 = new Select(forms);
        //select1.deselectAll();
    }


}
