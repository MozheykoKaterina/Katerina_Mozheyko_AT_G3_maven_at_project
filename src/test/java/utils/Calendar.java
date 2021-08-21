package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar {
    
    public static String inputDate(int datePlus) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.DATE, +datePlus);
        return dateFormat.format(cal.getTime());
    }
}
