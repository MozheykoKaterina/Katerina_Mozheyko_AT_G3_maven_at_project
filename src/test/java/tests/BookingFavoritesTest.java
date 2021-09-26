package tests;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import pages.*;
import utils.UserForBooking;

public class BookingFavoritesTest {
    
    private TrashmailPage trashMailPage = new TrashmailPage();
    private MailRuPage mailPageRu = new MailRuPage();
    private BookingRegisterPage bookingRegisterPage = new BookingRegisterPage();
    private BookingTravelPage bookingTravelPage = new BookingTravelPage();
    private BookingHotelPage bookingSaveFavoritesPage = new BookingHotelPage();
    private UserForBooking userForBooking = new UserForBooking();
    private String loginMailRu = userForBooking.getLoginPassword("login");
    private String passwordMailRu = userForBooking.getLoginPassword("password");
    private String passwordForBooking = userForBooking.getLoginPassword("passwordforbooking");
    private String loginTranshmail;
    
    @Test
    public void registerTrashMail() {
        String loginTranshmail = trashMailPage.createLoginTrashmail(loginMailRu);
        String loginConfirmMailRu = mailPageRu.confirmRegister(loginMailRu, passwordMailRu, "booking");
        Assert.assertEquals("Created user for booking ", loginConfirmMailRu, loginTranshmail);
    }
    
    @Test
    public void registerBooking() {
        //bookingRegisterPage.register(loginTranshmail, passwordForBooking);
        String confirm = mailPageRu.confirmRegister(loginMailRu, passwordMailRu, "booking");
        Assert.assertEquals("Confirmed successfully ", "Email confirmed", confirm);
    }
    
    @Test
    public void checkFavorites() {
        bookingRegisterPage.login("award@my10minutemail.com", passwordForBooking);
        bookingTravelPage.directionOfTravel("Мадрид");
        bookingTravelPage.setDateFromTo(10, 15);
        bookingTravelPage.startSearch();
        int count = bookingSaveFavoritesPage.getCountSaveFavorites();
        Assert.assertEquals("CountFavorites ", count, 2);
    }
    
    @AfterClass
    public void destroy() {
        Driver.destroy();
    }
}