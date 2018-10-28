package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.beans.User;
import by.it.basumatarau.project.java.controller.Action;
import by.it.basumatarau.project.java.controller.FormHandler;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ParseException {
        if(FormHandler.isPost(request, response)){

            String sqlStatement = String.format(" WHERE `Login`='%s' AND `Password`='%s' ;",
                    FormHandler.getString(request,"logininput", RegExPatterns.LOGIN_REG_EXP),
                    FormHandler.getString(request,"passwordinput", RegExPatterns.PASSWORD)
            );

            List<User> users = DAO.getDAO().user.getAll(sqlStatement);
            if(users.size()==1){
                HttpSession session = request.getSession(true);
                session.setAttribute("user", users.get(0));
                return Action.PROFILE.command;
            }

        }

        return null;
    }
}
