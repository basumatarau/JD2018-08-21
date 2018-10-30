package by.it.akhmelev.project7.java.controller;

import by.it.akhmelev.project7.java.beans.User;
import by.it.akhmelev.project7.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdEditUsers extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
        Dao dao = Dao.getDao();
        User admin = Util.getUser(req);
        if (admin == null)
            return Action.SIGNUP.cmd;
        if (Form.isPost(req)) {
            long id = Form.getLong(req, "id");
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            long roles_Id = Form.getLong(req, "roles_id");
            User user = new User(id, login, password, email, roles_Id);
            if (req.getParameter("Update") != null) {
                dao.user.update(user);
            }
            if (req.getParameter("Delete") != null) {
                dao.user.delete(user);
            }

        }
        req.setAttribute("roles", dao.role.getAll());
        req.setAttribute("users", dao.user.getAll());
        return null;
    }
}
