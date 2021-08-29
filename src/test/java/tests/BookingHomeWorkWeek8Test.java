package tests;

import driver.Driver;
import org.junit.*;
import org.testng.annotations.AfterTest;
import pages.*;
import pages1.BookingFilterPage;
import pages1.BookingGetPage;
import pages1.BookingJSPage;
import pages1.BookingOpenPage;

public class BookingHomeWorkWeek8Test {
    
    BookingTravelPage bookingTravelPage = new BookingTravelPage();
    BookingOpenPage bookingOpenPage = new BookingOpenPage();
    BookingJSPage bookingJSPage = new BookingJSPage();
    BookingGetPage bookingGetPage = new BookingGetPage();
    BookingFilterPage bookingFilterPage = new BookingFilterPage();

    @Test
    public void checkBookingScrolling() {
        bookingOpenPage.openBooking();
        bookingTravelPage.directionOfTravel("Москва");
        bookingTravelPage.search();
        bookingJSPage.javascriptExecutor("//div[@id='hotellist_inner']/div[10]", "arguments[0].scrollIntoView(true)");
        bookingJSPage.javascriptExecutor("//div[@id='hotellist_inner']/div[10]", "arguments[0].style.backgroundColor = 'green'");
        bookingJSPage.javascriptExecutor("//div[@id='hotellist_inner']/div[10]", "arguments[0].style.color = 'red'");
        bookingJSPage.javascriptExecutor("//div[@id='hotellist_inner']/div[10]", "arguments[0].click()");
        bookingGetPage.getCSSValue("//div[@id='hotellist_inner']/div[10]", "color");
        String color = bookingGetPage.getCSSValue("//div[@id='hotellist_inner']/div[10]", "color");
        System.out.println("Цвет заливки " + color);
        Assert.assertEquals(color, "#ff0000", color);
    }
    
    @Test
    public void checkBookingCurrency() {
        bookingOpenPage.openBooking();
        String currency = bookingGetPage.moveToElement("//nav/div[2]/div/button[@data-tooltip-text='Выберите валюту']");
        System.out.println("Currency hint value " + currency);
        Assert.assertEquals("Currency hint value", "Выберите валюту", currency);
    }
    
    @Test
    public void checkBookingLanguage() {
        bookingOpenPage.openBooking();
        String language = bookingGetPage.moveToElement("//nav/div[2]/div/button[@data-tooltip-text='Выберите язык']");
        System.out.println("Language hint value " + language);
        Assert.assertEquals("Language hint value", "Выберите язык", language);
    }
    
    @Test
    public void findBookingVariable() {
        bookingOpenPage.openBooking();
        bookingTravelPage.directionOfTravel("Москва");
        bookingTravelPage.setDateFromTo(1, 4);
        bookingTravelPage.search();
        int countVariable = bookingGetPage.getTextInteger("//h1[contains(.,'Москва')]");
        System.out.println("На выбранные даты найдено " + countVariable);
        Assert.assertTrue(countVariable > 0);
    }
    
    @Test
    public void checkBookingRating() {
        bookingOpenPage.openBooking();
        bookingTravelPage.directionOfTravel("Москва");
        bookingTravelPage.search();
        bookingFilterPage.filterBooking();
        int countRating = bookingGetPage.getTextInteger("//div[@id='hotellist_inner']//div[@class='bui-review-score__badge']");
        System.out.println("Актуальный рейтинг " +countRating / 10);
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