package by.it.galushka.project.java;

import by.it.galushka.project.java.beans.User;
import by.it.galushka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdSignUp extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            User user = new User(0, login, password, email, 2);
            Dao dao = Dao.getDao();
            dao.user.create(user);
            return Action.SIGNUP.cmd;
        }
        return null;
    }
}
