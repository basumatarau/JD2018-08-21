package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.Action;
import by.it.basumatarau.project.java.beans.User;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdSignUp extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        if(request.getMethod().equalsIgnoreCase("post")){

            String emailRegExp = "([-_А-Яа-яЁё\\w\\d]{1,40})@([-_А-Яа-яЁё\\w\\d]{1,20}).([-_А-Яа-яЁё\\w\\d]{1,4})";
            String loginRegExp = "([-_А-Яа-яЁё\\w\\d]{1,60})";

            if(!request.getParameter("logininput").matches(emailRegExp)||
                    !request.getParameter("passwordinput").matches(loginRegExp)){
                request.setAttribute("message", "Illegal password or login...");
                return null;
            }

            DAO dao = DAO.getDAO();

            String sqlStatement = String.format(" WHERE `Email`='%s' OR `LOGIN`='%s' ",
                    request.getParameter("emailinput"),
                    request.getParameter("logininput")
            );

            if(dao.user.getAll(sqlStatement).size()>0){
                request.setAttribute("message",
                        "<p>ERROR: User with this password or email is already registered </p>");
                return null;
            }

            dao.user.create(new User(
                    request.getParameter("logininput"),
                    request.getParameter("passwordinput"),
                    request.getParameter("emailinput"),
                    2
                    )
            );
            return Action.LOGIN.command;
        }

        return null;
    }
}
