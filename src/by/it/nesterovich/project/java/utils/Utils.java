package by.it.nesterovich.project.java.utils;

import by.it.nesterovich.project.java.beans.User;
import by.it.nesterovich.project.java.dao.Dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class Utils {

    public static User getUser(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object oUser = session.getAttribute("user");
            if (oUser != null) {
                return (User) oUser;
            }
        }
        if (session == null) {
            Cookie[] cookies = req.getCookies();
            String cookieLogin = "";
            String cookiePassword = "";
            if (cookies.length > 0) {
                for (int i = 0; i < cookies.length; i++) {
                    if ("login".equals(cookies[i].getName())) {
                        cookieLogin = cookies[i].getValue();
                    }
                    if ("password".equals(cookies[i].getName())) {
                        cookiePassword = cookies[i].getValue();
                    }
                }
                String where = String.format(" WHERE Login='%s' AND PASSWORD='%s'", cookieLogin, cookiePassword);
                List<User> users = Dao.getDao().user.getAll(where);
                return users.get(0);
            }
        }
        return null;
    }
}
