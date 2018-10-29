package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {

    //==================================================================================================================
    //извлекаем юзера из уже созданной сессии
    static User getUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object user = session.getAttribute("user");
            if (user != null) {
                return (User) user;
            }
        }
        return null;
    }

}
