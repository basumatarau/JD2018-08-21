package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.beans.User;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        if(request.getMethod().equalsIgnoreCase("post")){

            if(!request.getParameter("logininput").matches(RegExPatterns.emailRegExp)||
                    !request.getParameter("passwordinput").matches(RegExPatterns.loginRegExp)){
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
