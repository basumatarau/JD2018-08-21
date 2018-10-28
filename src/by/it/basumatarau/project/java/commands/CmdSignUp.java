package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.controller.Action;
import by.it.basumatarau.project.java.beans.User;
import by.it.basumatarau.project.java.controller.FormHandler;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdSignUp extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ParseException {
        if(FormHandler.isPost(request, response)){

            DAO dao = DAO.getDAO();

            String sqlStatement = String.format(" WHERE `Email`='%s' OR `LOGIN`='%s' ",
                    FormHandler.getString(request, "emailinput", RegExPatterns.EMAIL_REG_EXP),
                    FormHandler.getString(request, "logininput", RegExPatterns.LOGIN_REG_EXP)
            );

            if(dao.user.getAll(sqlStatement).size()>0){
                request.setAttribute("message",
                        "<p>ERROR: User with this password or email is already registered </p>");
                return null;
            }

            dao.user.create(new User(
                    FormHandler.getString(request, "logininput", RegExPatterns.LOGIN_REG_EXP),
                    FormHandler.getString(request, "passwordinput", RegExPatterns.PASSWORD),
                    FormHandler.getString(request, "emailinput", RegExPatterns.EMAIL_REG_EXP),
                    2
                    )
            );
            return Action.LOGIN.command;
        }

        return null;
    }
}
