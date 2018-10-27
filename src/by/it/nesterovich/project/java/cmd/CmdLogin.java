package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.beans.User;
import by.it.nesterovich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdLogin extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        req.setAttribute("user", "");
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            Dao dao = Dao.getDao();
            String where = String.format(" WHERE Login='%s' AND PASSWORD='%s'", login, password);
            List<User> users = dao.user.getAll(where);
            if (users.size() > 0) {
                req.setAttribute("user", users.get(0));
            }
        }
        return null;
    }
}
