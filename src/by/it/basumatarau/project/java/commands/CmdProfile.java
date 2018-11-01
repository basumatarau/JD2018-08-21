package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.beans.Place;
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
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ParseException {

        User user = Util.getUser(request);
        if(user==null){
            return Action.LOGIN.command;
        }

        if(FormHandler.isPost(request, response)){
            if(request.getParameter("logoutbutton")!=null) {
                request.getSession().removeAttribute("user");
                response.addCookie(new Cookie("pwdHash", ""));
                request.getSession(false).invalidate();
                return Action.LOGIN.command;
            }

            //to be fixed...
            if(request.getParameter("deleteVenue")!=null){
                Long id = FormHandler.getLong(request, "venueID");
                String venueName = FormHandler.getString(request, "venueName");
                String description = FormHandler.getString(request, "venueDescription");
                Timestamp openingDeteTime = FormHandler.getTimestamp(request, "venueOpeningDeteTime");
                Float fee = FormHandler.getFloat(request, "fee");

                DAO.getDAO().venue.delete(
                        new Venue(
                                id,
                                venueName,
                                description,
                                openingDeteTime,
                                fee,
                                user.getId(),
                                0
                        )
                );
            }
        }

        String sqlStatement = String.format(" WHERE Venues.Users_ID = %d ", user.getId());
        if(DAO.getDAO().role.read(user.getRoles_Id()).getRole().equalsIgnoreCase("admin")){
            sqlStatement = "";
        }

        List<Venue> usrVenues = new ArrayList<>();
        List<Place> venuePlaces = new ArrayList<>();

        DAO.getDAO().venue.getAllDetailed(sqlStatement, usrVenues, venuePlaces);


        request.setAttribute("userName", user.getLogin());
        request.setAttribute("userVenues", usrVenues);
        request.setAttribute("venuePlaces", venuePlaces);

        return null;
    }
}
