package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.beans.User;
import by.it.basumatarau.project.java.beans.Venue;
import by.it.basumatarau.project.java.controller.Action;
import by.it.basumatarau.project.java.controller.FormHandler;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response)throws SQLException, ParseException {

        HttpSession session = request.getSession(false);
        Object user = session.getAttribute("user");

        if(user==null){
            return Action.LOGIN.command;
        }

        if(FormHandler.isPost(request, response) &&
                request.getParameter("logoutbutton")!=null){

            request.getSession(false).invalidate();
            return Action.LOGIN.command;
        }

        String sqlStatement = String.format(" WHERE `Venues`.`Users_ID`= %d ;", ((User)user).getId());

        List<Venue> allUsrVenues = DAO.getDAO().venue.getAll(sqlStatement);

        session.setAttribute("userName", ((User) user).getLogin());
        session.setAttribute("usrVenues", allUsrVenues);
        return null;
    }
}
