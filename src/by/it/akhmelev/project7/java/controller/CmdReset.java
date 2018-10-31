package by.it.akhmelev.project7.java.controller;

import by.it.akhmelev.project7.java.beans.User;
import by.it.akhmelev.project7.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdReset extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
            Dao.getDao().reset();
            return Action.SIGNUP.cmd;
    }

    public static void main(String[] args) throws SQLException {
        String where = String.format(" WHERE Login='%s' AND PASSWORD='%s'","testLogin","testPassword");
        List<User> all = Dao.getDao().user.getAll(where);
        System.out.println(all.get(0));
    }
}
