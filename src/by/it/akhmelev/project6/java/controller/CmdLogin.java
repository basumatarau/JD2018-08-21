package by.it.akhmelev.project6.java.controller;

import by.it.akhmelev.project6.java.beans.User;
import by.it.akhmelev.project6.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isPost(req)) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            Dao dao = Dao.getDao();
            String where = String.format(" WHERE Login='%s' AND PASSWORD='%s'",login,password);
            List<User> users = dao.user.getAll(where);
            if (users.size()>0) {
                HttpSession session = req.getSession();
                session.setAttribute("user",users.get(0));
                return Action.PROFILE.cmd;
            }

        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        String where = String.format(" WHERE Login='%s' AND PASSWORD='%s'","testLogin","testPassword");
        List<User> all = Dao.getDao().user.getAll(where);
        System.out.println(all.get(0));
    }
}
