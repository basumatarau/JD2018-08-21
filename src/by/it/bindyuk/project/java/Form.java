package by.it.bindyuk.project.java;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class Form {
    static boolean isPost(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase("post");
    }

    static boolean isGet(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase("get");
    }

    static String getString(HttpServletRequest req, String param) throws ParseException {
        return getString(req, param, ".*");
    }

    static String getString(HttpServletRequest req, String param, String pattern) throws ParseException {
        String value = req.getParameter(param);
        if (value != null && value.matches(pattern)) {
            return value;
        } else throw new ParseException("Invalid string" + param, -1);
    }
}
