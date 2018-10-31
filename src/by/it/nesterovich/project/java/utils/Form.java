package by.it.nesterovich.project.java.utils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class Form {

    public static String getString(String value, String regexPattern) throws ParseException {
        if (value.trim().matches(regexPattern)) {
            return value;
        } else {
            throw new ParseException("Input error: " + value, 1);
        }
    }

    public static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("post");
    }

    public static boolean isGet(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("get");
    }
}
