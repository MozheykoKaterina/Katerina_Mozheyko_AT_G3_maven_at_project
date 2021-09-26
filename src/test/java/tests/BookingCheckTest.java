package tests;

import org.junit.*;
import pages.*;
import pages.BookingFilterHotelPage;
import pages.BookingJSPage;
import pages.BookingOpenPage;

public class BookingCheckTest {
    
    private BookingTravelPage bookingTravelPage = new BookingTravelPage();
    private BookingOpenPage bookingOpenPage = new BookingOpenPage();
    private BookingJSPage bookingJSPage = new BookingJSPage();
    private BookingFilterHotelPage bookingFilterHotelPage = new BookingFilterHotelPage();
    private BookingHotelPage bookingHotelPage = new BookingHotelPage();

    @Before
    public void openBooking() {
        bookingOpenPage.openBooking();
    }
    @Test
    public void checkBookingScrolling() {
        bookingTravelPage.directionOfTravel("Москва");
        bookingTravelPage.startSearch();
        String colorText = bookingJSPage.getColorElement("color");
        Assert.assertEquals("#ff0000", colorText);
    }
    
    @Test
    public void checkBookingCurrency() {
        String currency = bookingTravelPage.getValueTooltips("currency");
        Assert.assertEquals("Currency hint value", "Выберите валюту", currency);
    }
    
    @Test
    public void checkBookingLanguage() {
        String language = bookingTravelPage.getValueTooltips("language");
        Assert.assertEquals("Language hint value", "Выберите язык", language);
    }
    
    @Test
    public void findBookingVariable() {
        bookingTravelPage.directionOfTravel("Москва");
        bookingTravelPage.setDateFromTo(1, 4);
        bookingTravelPage.startSearch();
        int countVariable = bookingHotelPage.getCountVariable();
        Assert.assertTrue(countVariable > 0);
    }
    
    @Test
    public void checkBookingRating() {
        bookingTravelPage.directionOfTravel("Москва");
        bookingTravelPage.startSearch();
        bookingFilterHotelPage.filterReviewScore();
        double countRating = bookingHotelPage.getRaiting();
        Assert.assertTrue("Актуальный рейтинг ", countRating >= 9);
    }
    
    /*@AfterTest
    public static void closePage() {
        Driver.close();
    }
    
    @AfterClass
    public static void closeDriver() {
        Driver.destroy();
    }*/
}