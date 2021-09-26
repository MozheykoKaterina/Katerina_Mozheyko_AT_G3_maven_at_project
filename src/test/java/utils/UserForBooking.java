package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import settings.L4JLogging;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserForBooking {
    
    private static final String GET_USER_LOGIN = "src/test/resources/user.json";
    private static final Logger LOGGER =
            LogManager.getLogger(UserForBooking.class.getName());
    
    File file = new File(GET_USER_LOGIN);
    
    public static String getLoginPassword(String user) {
        String input = null;
        try {
            input = new String(Files.readAllBytes(Paths.get(GET_USER_LOGIN)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject obj = new JSONObject(input);
        if (user == "login") {
            LOGGER.info("Get user " + obj.getString("login"));
            return obj.getString("login");
        } else if (user == "password") {
            LOGGER.info("Get password " + obj.getString("password"));
            return obj.getString("password");
        } else if (user == "passwordforbooking") {
            LOGGER.info("Get passwordforbooking " + obj.getString("passwordforbooking"));
            return obj.getString("passwordforbooking");
        }
        return null;
    }
}
