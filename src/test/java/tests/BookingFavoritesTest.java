package tests;

import driver.Driver;
import org.junit.Assert;
import org.junit.Test;
import pages.*;

public class BookingFavoritesTest {
    
    static String mylogin;
    
    LogonMailPage logonMailPage = new LogonMailPage();
    DedicateRegisterPage dedicateRegisterPage = new DedicateRegisterPage();
    BookingRegisterPage bookingRegisterPage = new BookingRegisterPage();
    BookingLoginPage bookingLoginPage = new BookingLoginPage();
    BookingTravelPage bookingTravelPage = new BookingTravelPage();
    BookingSaveFavoritesPage bookingSaveFavoritesPage = new BookingSaveFavoritesPage();
    
    @Test
    public void registerTrashMail() throws InterruptedException {
        logonMailPage.logon();
        dedicateRegisterPage.dedicate();
        mylogin = logonMailPage.getLogin();
        Assert.assertEquals("Created user ", mylogin, dedicateRegisterPage.getMail());
        Driver.destroy();
    }
    
    @Test
    public void registerBooking() throws InterruptedException {
        //bookingRegisterPage.registerBooking("lauriane83@my10minutemail.com", "Qwerty1234");
        bookingRegisterPage.registerBooking(mylogin, "Qwerty1234");
        bookingRegisterPage.confirmRegisterBooking();
        Assert.assertEquals("Confirmed successfully ", "Подтвердите свой адрес электронной почты", bookingRegisterPage.confirmRegisterBooking());
        Driver.destroy();
        
    }
    
    @Test
    public void checkFavorites() {
        bookingLoginPage.loginBooking(mylogin, "Qwerty1234");
        bookingTravelPage.travel("Мадрид");
        bookingTravelPage.calendar(10, 15);
        bookingTravelPage.search();
        int count = bookingSaveFavoritesPage.saveFavorites();
        Assert.assertEquals("CountFavorites ", count, 2);
        Driver.destroy();
    }
}