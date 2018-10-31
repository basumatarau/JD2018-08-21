package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.beans.User;
import by.it.basumatarau.project.java.controller.Action;
import by.it.basumatarau.project.java.controller.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdSearch extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response)throws SQLException, ParseException {
        User user = Util.getUser(request);
        if(user==null){
            return Action.LOGIN.command;
        }

        return null;
    }
}
