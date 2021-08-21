package tests;

import driver.Driver;
import org.junit.*;
import org.testng.annotations.AfterTest;
import pages.BookingPage;

public class BookingHomeWorkWeek8Test {

    BookingPage bookingPage = new BookingPage();

    @Test
    public void checkBookingScrolling() {
        bookingPage.getUrl("https://booking.com");
        bookingPage.inputElement("//input[@aria-label='Пожалуйста, введите направление.']","Москва");
        bookingPage.clickElement("//button[@class='sb-searchbox__button ']");
        bookingPage.javascriptExecutor("//div[@id='hotellist_inner']/div[10]", "arguments[0].scrollIntoView(true)");
        bookingPage.javascriptExecutor("//div[@id='hotellist_inner']/div[10]", "arguments[0].style.backgroundColor = 'green'");
        bookingPage.javascriptExecutor("//div[@id='hotellist_inner']/div[10]", "arguments[0].style.color = 'red'");
        bookingPage.javascriptExecutor("//div[@id='hotellist_inner']/div[10]", "arguments[0].click()");
        bookingPage.getCSSValue("//div[@id='hotellist_inner']/div[10]", "color");
        String color = bookingPage.getCSSValue("//div[@id='hotellist_inner']/div[10]", "color");
        System.out.println("Цвет заливки " + color);
        Assert.assertEquals(color, "#ff0000", color);
    }
    
    @Test
    public void checkBookingCurrency() {
        bookingPage.getUrl("https://booking.com");
        String currency = bookingPage.moveToElement("//nav/div[2]/div/button[@data-tooltip-text='Выберите валюту']");
        System.out.println("Currency hint value " + currency);
        Assert.assertEquals("Currency hint value", "Выберите валюту", currency);
    }
    
    @Test
    public void checkBookingLanguage() {
        bookingPage.getUrl("https://booking.com");
        String language = bookingPage.moveToElement("//nav/div[2]/div/button[@data-tooltip-text='Выберите язык']");
        System.out.println("Language hint value " + language);
        Assert.assertEquals("Language hint value", "Выберите язык", language);
    }
    
    @Test
    public void findBookingVariable() {
        bookingPage.getUrl("https://booking.com");
        bookingPage.inputElement("//input[@aria-label='Пожалуйста, введите направление.']", "Москва");
        bookingPage.clickElement("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']");
        bookingPage.inputDate("//td[@data-date='%s']", 1);
        bookingPage.inputDate("//td[@data-date='%s']", 4);
        bookingPage.clickElement("//button[@class='sb-searchbox__button ']");
        int countVariable = bookingPage.getTextInteger("//h1[contains(.,'Москва')]");
        System.out.println("На выбранные даты найдено " + countVariable);
        Assert.assertTrue(countVariable > 0);
    }
    
    @Test
    public void checkBookingRating() {
        bookingPage.getUrl("https://booking.com");
        bookingPage.inputElement("//input[@aria-label='Пожалуйста, введите направление.']", "Москва");
        bookingPage.clickElement("//ul[@aria-label='Список рекомендуемых направлений']");
        bookingPage.clickElement("//button[@class='sb-searchbox__button ']");
        bookingPage.closeMap("//div[@aria-label='Close map']");
        bookingPage.clickElement("//div[@id='filterbox_options']/div/div[@id='filter_review'][1]/div[2]/a[@data-id='review_score-90']");
        bookingPage.spinnerWait(".bui-spinner.bui-spinner--size-large");
        int countRating = bookingPage.getTextInteger("//div[@id='hotellist_inner']//div[@class='bui-review-score__badge']");
        System.out.println("Актуальный рейтинг " + countRating / 10);
        Assert.assertTrue(countRating/10 >= 9);
    }
    
    @AfterTest
    public static void closePage() {
        Driver.close();
    }
    
    @AfterClass
    public static void closeDriver() {
        Driver.destroy();
    }
}