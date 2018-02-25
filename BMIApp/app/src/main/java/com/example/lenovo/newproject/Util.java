package com.example.lenovo.newproject;

/**
 * Created by Lenovo on 2/24/2018.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Util {

        // isValidEmailAddress: Check the email address is OK
        public  boolean isValidEmailAddress(String emailAddress) {
            String emailRegEx;
            Pattern pattern;
            // Regex for a valid email address
            emailRegEx = "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$";
            // Compare the regex with the email address
            pattern = Pattern.compile(emailRegEx);
            Matcher matcher = pattern.matcher(emailAddress);
            if (!matcher.find()) {
                return false;
            }
            return true;

    }

}
