package utils;

import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONUserBooking {
    
    private static final String JSON = "src/test/resources/user.json";
    
    File file = new File(JSON);
    
    public String parseLogin() {
        String input = null;
        try {
            input = new String(Files.readAllBytes(Paths.get(JSON)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject obj = new JSONObject(input);
        return obj.getString("login");
    }
    
    public String parsePassword() {
        String input = null;
        try {
            input = new String(Files.readAllBytes(Paths.get(JSON)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject obj = new JSONObject(input);
        return obj.getString("password");
    }
    
    public String parsePasswordForBooking() {
        String input = null;
        try {
            input = new String(Files.readAllBytes(Paths.get(JSON)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject obj = new JSONObject(input);
        return obj.getString("passwordforbooking");
    }
}