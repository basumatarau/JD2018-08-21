package by.it.basumatarau.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.ParseException;

public class FormHandler {
    public static boolean isGet(HttpServletRequest request, HttpServletResponse response){
        return request.getMethod().equalsIgnoreCase("get");
    }
    public static boolean isPost(HttpServletRequest request, HttpServletResponse response){
        return request.getMethod().equalsIgnoreCase("post");
    }

    public static String getString(HttpServletRequest request, String param)
            throws ParseException{
        return getString(request, param, ".*");
    }

    public static String getString(HttpServletRequest request, String param, String pattern)
            throws ParseException{
        String attrValue = request.getParameter(param);
        if(attrValue!=null && attrValue.matches(pattern)){
            return attrValue;
        }
        throw new ParseException(
                String.format("Field %s doesn't match the security pattern", param),
                0
        );
    }

    public static Integer getInt(HttpServletRequest request, String param)
            throws ParseException{
        String attrValue = request.getParameter(param);
        try {
            return Integer.parseInt(attrValue);
        }catch (NumberFormatException e){
            throw new ParseException(
                    String.format("Field %s doesn't match the number format pattern", param),
                    0
            );
        }
    }

    public static Double getDouble(HttpServletRequest request, String param)
            throws ParseException{
        String attrValue = request.getParameter(param);
        try {
            return Double.parseDouble(attrValue);
        }catch (NumberFormatException e){
            throw new ParseException(
                    String.format("Field %s doesn't match the number format pattern", param),
                    0
            );
        }
    }


    public static Float getFloat(HttpServletRequest request, String param)
            throws ParseException{
        String attrValue = request.getParameter(param);
        try {
            return Float.parseFloat(attrValue);
        }catch (NumberFormatException e){
            throw new ParseException(
                    String.format("Field %s doesn't match the number format pattern", param),
                    0
            );
        }
    }

    public static Timestamp getTimestamp(HttpServletRequest request, String param)
            throws ParseException{
        String attrValue = request.getParameter(param);
        try {
            return Timestamp.valueOf(attrValue);
        }catch (IllegalArgumentException  e){
            throw new ParseException(
                    String.format("Field %s doesn't match the Timestamp format pattern", param),
                    0
            );
        }
    }

}
