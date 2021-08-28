package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogonMailPage {
    
    WebDriver driver = Driver.getWebDriver();
    static String login;
    
    public void logon() {
        driver.get("https://trashmail.com/");
        driver.findElement(By.xpath("//button[contains(.,'Choose among the following')]")).click();
        Actions make = new Actions(driver);
        make
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        WebElement realEmail = driver.findElement(By.xpath("//input[@id='fe-forward']"));
        realEmail.click();
        realEmail.sendKeys("katik010489@mail.ru");
        driver.findElement(By.xpath("//form[@name='tm-login-form']/div[@class='input-group input-group-sm input-group-btn']/div[@class='input-group-btn']")).click();
        driver.findElement(By.xpath("//ul[@tabindex='-1']")).click();
        driver.findElement(By.xpath("//div/div[@class='input-group input-group-sm input-group-btn']/div[@class='input-group-btn']")).click();
        driver.findElement(By.xpath("//ul[@tabindex='-1']")).click();
        driver.findElement(By.xpath("//button[@id='fe-submit']")).click();
        WebElement logon = driver.findElement(By.xpath("//input[@id='fe-dea']"));
        login = logon.getAttribute("value");
        System.out.println(login);
    }
    
    public String getLogin() {
        return login;
    }
}
