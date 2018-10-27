package by.it.akhmelev.project6.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

class Form {

    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("post");
    }

    static boolean isGet(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("get");
    }

    static String getString(HttpServletRequest request, String name)  throws ParseException {
        return getString(request, name, ".*");
    }

    static String getString(HttpServletRequest request, String name, String pattern) throws ParseException {
        String value = request.getParameter(name);
        if (value != null && value.matches(pattern))
            return value;
        throw new ParseException("Field "+name+" incorrect. ",0);
    }

    static Integer getInt(HttpServletRequest request, String name)  throws ParseException {
        String value = request.getParameter(name);
        if (value != null && value.matches("[-0-9]+"))
            return Integer.valueOf(value);
        throw new ParseException("Field "+name+" incorrect. ",0);

    }

    static Double getDouble(HttpServletRequest request, String name)  throws ParseException {
        String value = request.getParameter(name);
        if (value != null && value.matches("[-0-9.]+"))
            return Double.valueOf(value);
        throw new ParseException("Field "+name+" incorrect. ",0);
    }

}
