package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.Action;
import by.it.nesterovich.project.java.beans.User;
import by.it.nesterovich.project.java.dao.Dao;
import by.it.nesterovich.project.java.utils.Form;
import by.it.nesterovich.project.java.utils.Patterns;
import by.it.nesterovich.project.java.utils.Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req);
        if (user != null) {
            return Action.USERCABINET.cmd;
        }
        if (Form.isPost(req)) {
            String login = Form.getString(req.getParameter("login"), Patterns.LOGIN);
            String password = Form.getString(req.getParameter("password"), Patterns.PASSWORD);
            Dao dao = Dao.getDao();
            String where = String.format(" WHERE Login='%s' AND PASSWORD='%s'", login, password);
            List<User> users = dao.user.getAll(where);
            if (users.size() > 0) {
                HttpSession session = req.getSession();
                session.setMaxInactiveInterval(30);
                session.setAttribute("user", users.get(0));
                Cookie cookieLogin = new Cookie("login", login);
                Cookie cookiePassword = new Cookie("password", password);
                cookieLogin.setMaxAge(60);
                cookiePassword.setMaxAge(60);
                resp.addCookie(cookieLogin);
                resp.addCookie(cookiePassword);
                return Action.USERCABINET.cmd;
            } else {
                req.setAttribute("user", "no user: " + login + " or incorrect password");
            }
        }
        return null;
    }
}
