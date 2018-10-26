package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.Action;
import by.it.nesterovich.project.java.beans.User;
import by.it.nesterovich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdSignUp extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            int phoneNumber = Integer.parseInt(req.getParameter("phoneNumber"));
            User user = new User(0, login, password, email, firstName, lastName, phoneNumber, 2);
            Dao dao = Dao.getDao();
            dao.user.create(user);
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
