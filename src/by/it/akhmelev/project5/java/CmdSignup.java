package by.it.akhmelev.project5.java;

import by.it.akhmelev.project5.java.beans.User;
import by.it.akhmelev.project5.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdSignup extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            User user = new User(0, login, password, email, 2);
            Dao dao = Dao.getDao();
            dao.user.create(user);
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
