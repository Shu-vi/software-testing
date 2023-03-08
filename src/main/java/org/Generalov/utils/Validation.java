package org.Generalov.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static Boolean checkLogin(String login) {
        if (login == null)
            return false;
        if (login.length() > 35 || login.length() < 7)
            return false;
        Pattern pattern = Pattern.compile("^[a-zA-Z\\d._%+-]+@[a-zA-Z\\d-]+.+.[A-Za-z]{2,4}$");
        Matcher matcher = pattern.matcher(login);
        return matcher.find();
    }

    public static Boolean checkPassword(String password) {
        if (password == null)
            return false;
        return password.length() <= 35 && password.length() >= 7;
    }
}
