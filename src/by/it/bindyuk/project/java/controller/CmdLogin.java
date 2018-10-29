package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.User;
import by.it.bindyuk.project.java.dao.dao.Dao;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isPost(req)) {
            try {
                String login = req.getParameter("login");
                String password = req.getParameter("password");
                Dao dao = Dao.getDao();
                String where = " WHERE login='" + login + "' AND password='" + password + "'";
                List<User> users = dao.user.getAll(where);
                if (users.size() > 0) {
                    HttpSession session = req.getSession();
                    session.setMaxInactiveInterval(30);                         //время жезни сессии без опроса страницы
                    Cookie myCookies = new Cookie(login, DigestUtils.md5Hex(password)); //создаем куки и хэшируем пароль
                    myCookies.setMaxAge(60);                                            //время жизни куки
                    resp.addCookie(myCookies);                                          //добавление куки в ответ
                    session.setAttribute("user", users.get(0));
                    return Action.PROFILE.cmd;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
