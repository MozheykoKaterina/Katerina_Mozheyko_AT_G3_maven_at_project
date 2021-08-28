package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DedicateRegisterPage {
    
    WebDriver driver = Driver.getWebDriver();
    static String mail;
    
    public void dedicate() {
        driver.get("https://mail.ru/");
        WebElement login = driver.findElement(By.xpath("//input[@name='login']"));
        login.click();
        login.sendKeys("katik010489");
        driver.findElement(By.xpath("//button[@data-testid='enter-password']")).click();
        WebElement password = driver.findElement(By.xpath("//input[@data-testid='password-input']"));
        password.click();
        password.sendKeys("7741693Bolik");
        driver.findElement(By.xpath("//button[@data-testid='login-to-mail']")).click();
        driver.findElement(By.xpath("//div[@class='dataset__items']/a[1]")).click();
        WebElement email = driver.findElement(By.xpath("//div[@class='html-expander']/div/div/div/a[1]"));
        mail = email.getText();
        System.out.println(mail);
    }
    
    public String getMail() {
        return mail;
    }
}