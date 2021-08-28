package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingSaveFavoritesPage {
    
    WebDriver driver = Driver.getWebDriver();
    
    public Integer saveFavorites() {
        driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[1]/div/div/button[@data-title='Сохранить']")).click();
        driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[last()]/div/div/button[@data-title='Сохранить']")).click();
        driver.findElement(By.xpath("//span[@id='profile-menu-trigger--title']")).click();
        driver.findElement(By.xpath("//span[contains(.,'Сохраненное')]")).click();
        System.out.println("Count favorites " + driver.findElements(By.xpath("//img[@class='bui-card__image js-listview-book js-listview-hotel-image']")).size());
        return driver.findElements(By.xpath("//img[@class='bui-card__image js-listview-book js-listview-hotel-image']")).size();
    }
}