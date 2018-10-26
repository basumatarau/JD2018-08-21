package by.it.bindyuk.project.java;

import by.it.bindyuk.project.java.dao.beans.User;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("get")) {
            Dao dao = Dao.getDao();
            List<User> all = dao.user.getAll();
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            for (User user : all) {
                if (user != null) {
                    if (user.getLogin().equals(login) & user.getPassword().equals(password)) {
                        return Action.PROFILE.cmd;
                    }
                }
            }
        }
        return Action.LOGIN.cmd;
    }
}
