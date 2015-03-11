/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.util.Calendar;
import static java.util.Calendar.DAY_OF_YEAR;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author mats
 */
public class FieldValidations {
    private FieldValidations() {
        throw new AssertionError();
    }
    
    public static boolean isValidEmail(String email) {
        if (email.equals("")) {
            return false;
        } else {
            boolean result = true;
            try {
               InternetAddress emailAddr = new InternetAddress(email);
               emailAddr.validate();
            } catch (AddressException ex) {
               result = false;
            }
            return result;
        }
    }
    
    public static boolean isValidPersnbr(String persnbr) {
        String yearStr;
        String monthStr;
        String dayStr;
        String secretStr;
        
        if (persnbr.indexOf("-") != -1 && persnbr.indexOf("-") != persnbr.length() - 5) {
            return false;
        }
        
        persnbr = persnbr.replaceFirst("-", "");
        
        if (persnbr.length() == 10) {
            yearStr = persnbr.substring(0, 2);
            persnbr = persnbr.substring(2);
        } else if (persnbr.length() == 12) {
            yearStr = persnbr.substring(0, 4);
            persnbr = persnbr.substring(4);
        } else {
            return false;
        }
        
        monthStr = persnbr.substring(0, 2);
        dayStr = persnbr.substring(2, 4);
        secretStr = persnbr.substring(4, 8);
        
        int year;
        int month;
        int day;
        int secret;

        try {
            year = Integer.parseInt(yearStr);
            month = Integer.parseInt(monthStr);
            day = Integer.parseInt(dayStr);
            secret = Integer.parseInt(secretStr);
        } catch (NumberFormatException e) {
            return false;
        }
        
        if (year > 0
                && month >= 1 && month <= 12
                && day >= 1 && day <= daysInMonth(month, year)) {
            return true;
        }
        
        return false;
    }
    
    public static boolean isValidPostCode(String postCode) {
        if (postCode.indexOf(" ") != -1 && postCode.indexOf(" ") != postCode.length() - 3) {
            return false;
        }
        
        postCode = postCode.replaceFirst(" ", "");
        
        if (postCode.length() != 5) {
            return false;
        }
        
        try {
            int i = Integer.parseInt(postCode);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    public static boolean isValidPhoneNumber(String number) {
        return number.replaceFirst("-", "").replace(" ", "").matches("^(\\+?46|0)7\\d{8}$")
                && !number.contains("  ");
    }
    
    public static int daysInMonth(int m, int y) {
        switch (m) {
            case 2:
                if (isLeapYear(y)) {
                    return 29;
                } else {
                    return 28;
                }
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
        }
        return 0;
    }
    
    public static boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(DAY_OF_YEAR) > 365;
    }
}
