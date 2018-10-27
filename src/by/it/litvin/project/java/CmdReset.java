package by.it.litvin.project.java;

import by.it.litvin.project.java.dao.Dao;
import by.it.litvin.project.java.dao.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdReset extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) {
        Dao.getDao().reset();
        return Action.SIGNUP.cmd;

    }

//    public static void main(String[] args) throws SQLException {
//        String where = String.format(" WHERE Login='%s' AND PASSWORD='%s'", "testLogin", "testPassword");
//        List<User> all = Dao.getDao().user.getAll(where);
//        System.out.println(all.get(0));
//    }
}

