package tests;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import pages.*;
import utils.JSONUserBooking;

public class BookingFavoritesTest {
    
    private TrashmailPage trashMailPage = new TrashmailPage();
    private MailPage mailPage = new MailPage();
    private BookingRegisterPage bookingRegisterPage = new BookingRegisterPage();
    private BookingTravelPage bookingTravelPage = new BookingTravelPage();
    private BookingHotelPage bookingSaveFavoritesPage = new BookingHotelPage();
    private JSONUserBooking jsonUserBooking = new JSONUserBooking();
    
    @Test
    public void registerTrashMail() {
        trashMailPage.getLoginTrashmail(jsonUserBooking.parseLogin());
        String emailTranshmail = mailPage.confirmRegister(jsonUserBooking.parseLogin(), jsonUserBooking.parsePassword(),MailPage.TRASHMAIL);
        Assert.assertEquals("Created user for booking ", trashMailPage.getLogin(), emailTranshmail);
    }
    
    @Test
    public void registerBooking() {
        bookingRegisterPage.register(trashMailPage.getLogin(), jsonUserBooking.parsePasswordForBooking());
        String confirm = mailPage.confirmRegister(jsonUserBooking.parseLogin(), jsonUserBooking.parsePassword(), MailPage.BOOKING);
        Assert.assertEquals("Confirmed successfully ", "Подтверждаю", confirm);
    }
    
    @Test
    public void checkFavorites() {
        bookingRegisterPage.login("award@my10minutemail.com", jsonUserBooking.parsePasswordForBooking());
        bookingTravelPage.directionOfTravel("Мадрид");
        bookingTravelPage.setDateFromTo(10, 15);
        bookingTravelPage.search();
        int count = bookingSaveFavoritesPage.saveFavorites();
        Assert.assertEquals("CountFavorites ", count, 2);
    }
    
    @AfterClass
    public void destroy() {
        Driver.destroy();
    }
}