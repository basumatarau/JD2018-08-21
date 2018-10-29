package by.it.bindyuk.project.java;

import by.it.bindyuk.project.java.dao.beans.User;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isGet(req)) {
            Dao dao = Dao.getDao();
            List<User> all = dao.user.getAll();
            String login = req.getParameter("login");
            String password = req.getParameter("password");

        }
        return Action.LOGIN.cmd;
    }
}
