package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.Action;
import by.it.basumatarau.project.java.beans.User;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        if(request.getMethod().equalsIgnoreCase("post")){

            String emailRegExp = "([-_А-Яа-яЁё\\w\\d]{1,40})@([-_А-Яа-яЁё\\w\\d]{1,20}).([-_А-Яа-яЁё\\w\\d]{1,4})";
            String loginRegExp = "([-_А-Яа-яЁё\\w\\d]{1,60})";

            if(!request.getParameter("logininput").matches(emailRegExp)||
                    !request.getParameter("passwordinput").matches(loginRegExp)){
                request.setAttribute("user", "Illegal password or login...");
            }

            String sqlStatement = String.format(" WHERE `Login`='%s' AND `Password`='%s' ;",
                    request.getParameter("logininput"),
                    request.getParameter("passwordinput")
            );

            List<User> users = DAO.getDAO().user.getAll(sqlStatement);
            if(users.size()==1){
                request.setAttribute("user", users.get(0));
            }
        }

        return null;
    }
}
