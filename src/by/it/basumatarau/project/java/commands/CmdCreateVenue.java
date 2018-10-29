package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.controller.Action;
import by.it.basumatarau.project.java.beans.Place;
import by.it.basumatarau.project.java.beans.Venue;
import by.it.basumatarau.project.java.beans.User;
import by.it.basumatarau.project.java.controller.FormHandler;
import by.it.basumatarau.project.java.controller.Util;
import by.it.basumatarau.project.java.customDAO.DAO;
import by.it.basumatarau.project.java.customDAO.PlaceDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdCreateVenue extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ParseException {

        User user = Util.getUser(request);
        if(user==null){
            return Action.LOGIN.command;
        }

        if(FormHandler.isPost(request, response)){
            Place place = new Place(
                    FormHandler.getString(request, "placenameinput", RegExPatterns.PLACE_NAME),
                    FormHandler.getString(request, "addressinput", RegExPatterns.ADDRESS)
                    );
            PlaceDAO placeDAO = DAO.getDAO().place;

            List<Place> places = placeDAO.getAll(
                    String.format(" WHERE `Name`='%s' ;", place.getName())
            );

            if(places.size()>0){
                place = places.get(0);
            }else {
                placeDAO.create(place);
            }

            Venue venue = new Venue(
                    FormHandler.getString(request, "nameinput", RegExPatterns.VENUE_NAME),
                    FormHandler.getString(request, "descriptioninput", RegExPatterns.VENUE_DESCRIPTION),
                    FormHandler.getTimestamp(request, "datetimeinput"),
                    FormHandler.getFloat(request, "feeinput"),
                    user.getId(),
                    place.getId()
            );

            DAO.getDAO().venue.create(venue);

            return Action.LISTVENUES.command;
        }

        return null;
    }
}
