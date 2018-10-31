package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.beans.User;
import by.it.basumatarau.project.java.controller.Action;
import by.it.basumatarau.project.java.controller.FormHandler;
import by.it.basumatarau.project.java.controller.Util;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.http.Cookie;
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
                User user = users.get(0);
                HttpSession session = request.getSession(true);

                session.setMaxInactiveInterval(30);
                session.setAttribute("user", user);

                Cookie userID = new Cookie("userID", Long.toString(user.getId()));
                Cookie pwdHash = new Cookie("pwdHash", Util.getPwdHash(user.getPassword(), user.getEmail()));
                userID.setMaxAge(60);
                pwdHash.setMaxAge(60);
                response.addCookie(userID);
                response.addCookie(pwdHash);

                return Action.PROFILE.command;
            }else {
                request.setAttribute("message", "Wrong username or password");
            }

        }

        return null;
    }
}
