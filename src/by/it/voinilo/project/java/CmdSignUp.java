package by.it.voinilo.project.java;

import by.it.voinilo.project.java.beans.Roleparam;
import by.it.voinilo.project.java.entitydao.AbstractDao;
import by.it.voinilo.project.java.entitydao.Dao;
import by.it.voinilo.project.java.entitydao.Roleparam_Dao;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdSignUp extends Cmd{
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse response) {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            Roleparam user = new Roleparam(0, login, password, email,2);
           // Dao dao = Dao
        }
        return null;

    }

}
