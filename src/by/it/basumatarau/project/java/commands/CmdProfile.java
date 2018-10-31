package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.beans.User;
import by.it.basumatarau.project.java.beans.Venue;
import by.it.basumatarau.project.java.controller.Action;
import by.it.basumatarau.project.java.controller.FormHandler;
import by.it.basumatarau.project.java.controller.Util;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response)throws SQLException{

        User user = Util.getUser(request);
        if(user==null){
            return Action.LOGIN.command;
        }

        if(FormHandler.isPost(request, response) &&
                request.getParameter("logoutbutton")!=null){
            request.getSession().removeAttribute("user");
            response.addCookie(new Cookie("pwdHash",""));
            request.getSession(false).invalidate();
            return Action.LOGIN.command;
        }

        String sqlStatement = String.format(" WHERE `Venues`.`Users_ID`= %d ;", user.getId());

        List<Venue> allUsrVenues = DAO.getDAO().venue.getAll(sqlStatement);

        request.setAttribute("userName", user.getLogin());
        request.setAttribute("usrVenues", allUsrVenues);
        return null;
    }
}
