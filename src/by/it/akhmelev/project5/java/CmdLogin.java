package by.it.akhmelev.project5.java;

import by.it.akhmelev.project5.java.beans.User;
import by.it.akhmelev.project5.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("user","kuku");
        if (req.getMethod().equalsIgnoreCase("post")) {
            req.setAttribute("user","kuku2");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            Dao dao = Dao.getDao();
            String where = String.format(" WHERE Login='%s' AND PASSWORD='%s'",login,password);
            List<User> users = dao.user.getAll(where);
            if (users.size()>0) {
                req.setAttribute("user",users.get(0));
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
