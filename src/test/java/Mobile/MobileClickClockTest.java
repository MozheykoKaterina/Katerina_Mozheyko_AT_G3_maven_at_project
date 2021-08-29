package Mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileClickClockTest {
    
    public static void main(String[] args) throws MalformedURLException {
    
        DesiredCapabilities caps = new DesiredCapabilities();
    
        caps.setCapability("deviceName", "Pixel 3");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.deskclock");
        caps.setCapability("appActivity", "com.android.deskclock.DeskClock");
    
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>
                (new URL("http://0.0.0.0:4723/wd/hub"), caps);

    }
}