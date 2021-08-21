package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.BookingFavoritesPage;

public class BookingFavoritesTest {
    
    BookingFavoritesPage bookingFavoritesPage = new BookingFavoritesPage();
    
    @Test
    public void checkBookingRegister() throws InterruptedException {
        //bookingFavoritesPage.login();
        bookingFavoritesPage.getUrl("https://booking.com");
        bookingFavoritesPage.clickElement("//span[contains(.,'Зарегистрироваться')]");
        bookingFavoritesPage.clickRegister("//input[@id='username']", "Qwerty1234");
        Assert.assertTrue(bookingFavoritesPage.isVisible("//span[contains(.,'Начать поиск')]"));
        bookingFavoritesPage.clickElement("//span[contains(.,'Начать поиск')]");
    }
    
    
    @Test
    public void checkFavorites() {
        bookingFavoritesPage.getUrl("https://booking.com");
        bookingFavoritesPage.clickElement("//span[contains(.,'Войти в аккаунт')]");
        bookingFavoritesPage.inputElement("//input[@id='username']", "kstokes@my10minutemail.com");
        bookingFavoritesPage.clickElement("//span[contains(.,'Продолжить')]");
        bookingFavoritesPage.inputElement("//input[@id='password']", "Qwerty1234");
        bookingFavoritesPage.clickElement("//span[contains(.,'Войти')]");
        //bookingFavoritesPage.clickElement("//span[contains(.,'Начать поиск')]");
        bookingFavoritesPage.inputElement("//input[@aria-label='Пожалуйста, введите направление.']", "Мадрид");
        bookingFavoritesPage.clickElement("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']");
        bookingFavoritesPage.inputDate("//td[@data-date='%s']", 30);
        bookingFavoritesPage.inputDate("//td[@data-date='%s']", 35);
        bookingFavoritesPage.clickElement("//button[@class='sb-searchbox__button ']");
        bookingFavoritesPage.clickElement("//div[@id='hotellist_inner']/div[1]/div/div/button[@data-title='Сохранить']");
        bookingFavoritesPage.clickElement("//div[@id='hotellist_inner']/div[last()]/div/div/button[@data-title='Сохранить']");
        bookingFavoritesPage.clickElement("//span[@id='profile-menu-trigger--title']");
        bookingFavoritesPage.clickElement("//span[contains(.,'Сохраненное')]");
        int countFavorit = bookingFavoritesPage.isElementPresent("//img[@class='bui-card__image js-listview-book js-listview-hotel-image']");
        Assert.assertEquals(countFavorit, 2);
}
}