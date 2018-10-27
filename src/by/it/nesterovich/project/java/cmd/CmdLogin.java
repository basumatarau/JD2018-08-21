package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.Action;
import by.it.nesterovich.project.java.beans.User;
import by.it.nesterovich.project.java.dao.Dao;
import by.it.nesterovich.project.java.ulils.Form;
import by.it.nesterovich.project.java.ulils.Patterns;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdLogin extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        req.setAttribute("user", "");
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = Form.getString(req.getParameter("login"), Patterns.LOGIN);
            String password = Form.getString(req.getParameter("password"), Patterns.PASSWORD);
            Dao dao = Dao.getDao();
            String where = String.format(" WHERE Login='%s' AND PASSWORD='%s'", login, password);
            List<User> users = dao.user.getAll(where);
            if (users.size() > 0) {
                return Action.USERCABINET.cmd;
            } else {
                req.setAttribute("user", "no user: " + login + " or incorrect password");
            }
        }
        return null;
    }
}
