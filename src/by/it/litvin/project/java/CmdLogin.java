package by.it.litvin.project.java;

import by.it.litvin.project.java.dao.Dao;
import by.it.litvin.project.java.dao.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
//        req.setAttribute("user", "player");
        if (req.getMethod().equalsIgnoreCase("post")) {
            req.setAttribute("user", "player");
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

//    public static void main(String[] args) throws SQLException {
//        String where = String.format(" WHERE Login='%s' AND PASSWORD='%s'", "testLogin", "testPassword");
//        List<User> all = Dao.getDao().user.getAll(where);
//        System.out.println(all.get(0));
//    }
}
