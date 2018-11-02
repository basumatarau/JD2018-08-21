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
            //todo finalize the func...
            if(request.getParameter("updateProfile")!=null){
                String login = FormHandler.getString(request, "login");
                String email = FormHandler.getString(request, "email");
                Integer roles_id = FormHandler.getInt(request, "roles_id");
                String password = FormHandler.getString(request, "password");

                User updatedUser = new User(
                        user.getId(),
                        login,
                        password,
                        email,
                        roles_id
                );

                if(DAO.getDAO().user.update(updatedUser)){
                    request.getSession().setAttribute("user", updatedUser);
                }
            }


        }

        int itmesPerPage = 10;
        int startPage = 1;
        if (request.getParameter("startPage") != null) {
            startPage = FormHandler.getInt(request, "startPage");
        }

        String getCountQuery=String.format(" WHERE `Venues`.`Users_ID` = %d ",
                user.getId());

        String sqlQuery = String.format(" WHERE `Venues`.`Users_ID` = %d LIMIT %s,10 ",
                user.getId(),
                (startPage-1)*10);

        if(DAO.getDAO().role.read(user.getRoles_Id()).getRole().equalsIgnoreCase("admin")){
            getCountQuery="";
            sqlQuery = String.format(" LIMIT %s,10 ",(startPage-1)*10);
        }
        Long count = DAO.getDAO().venue.getCount(getCountQuery);

        if(startPage<1||startPage-1>count/itmesPerPage){
            startPage=1;
        }

        List<Venue> usrVenues = new ArrayList<>();
        List<Place> venuePlaces = new ArrayList<>();

        DAO.getDAO().venue.getAllDetailed(sqlQuery, usrVenues, venuePlaces);

        request.setAttribute("userVenues", usrVenues);
        request.setAttribute("venuePlaces", venuePlaces);

        request.setAttribute("itemsPerPage", itmesPerPage);
        request.setAttribute("totalCount", count);
        request.setAttribute("currentPage", startPage);

        request.setAttribute("roles", DAO.getDAO().role.getAll(""));

        return null;
    }
}
