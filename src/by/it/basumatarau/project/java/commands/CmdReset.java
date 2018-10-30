package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.customDAO.DB_init;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdReset extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ParseException {

        request.getSession().removeAttribute("user");
        response.addCookie(new Cookie("pwdHash",null));

        request.getSession(false).invalidate();

        DB_init.createDBplusInserts();
        return null;
    }
}
