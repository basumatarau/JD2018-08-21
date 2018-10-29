package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.User;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdSignup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", Patterns.LOGIN);
            String password = Form.getString(req, "password", Patterns.PASSWORD);
            String email = Form.getString(req, "email", Patterns.EMAIL);
            String passportseries = Form.getString(req,"passportseries",Patterns.PASSPORTSERIES);
            int passportid = Integer.parseInt(Form.getString(req,"passportid",Patterns.PASSPORTID));
            String bancard = Form.getString(req,"bancard",Patterns.BANCARD);
            int cid = Integer.parseInt(Form.getString(req,"cid",Patterns.CID));
            Dao dao = Dao.getDao();
            User user = new User(0, login, password, email, passportseries, passportid, bancard, cid, 2);
            dao.user.create(user);
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
