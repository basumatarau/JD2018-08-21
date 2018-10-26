package by.it.bindyuk.project.java;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class Form {

    static String getString(HttpServletRequest req, String param, String pattern) throws ParseException {
        String value = req.getParameter(param);
        if (value != null && value.matches(pattern)) {
            return value;
        } else throw new ParseException("Invalid string" + param, -1);

    }

}
