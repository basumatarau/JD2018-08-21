package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.Action;
import by.it.basumatarau.project.java.beans.Place;
import by.it.basumatarau.project.java.beans.Venue;
import by.it.basumatarau.project.java.customDAO.DAO;
import by.it.basumatarau.project.java.customDAO.PlaceDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class CmdCreateVenue extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        if(request.getMethod().equalsIgnoreCase("post")){

            String venueName = "([-_А-Яа-яЁё\\w\\d ]{1,90})";
            String venueDescription = "([-_А-Яа-яЁё\\w\\d ]{1,90})";
            String venueFee = "([.,\\d]{1,60})";
            String placeName = "([-_А-Яа-яЁё\\w\\d,. ]{1,40})";
            String address = "([-_А-Яа-яЁё\\w\\d,. ]{1,40})";
            String dateTime = "\\s*\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\s*";

            if(!request.getParameter("nameinput").matches(venueName)
                    ||!request.getParameter("descriptioninput").matches(venueDescription)
                    ||!request.getParameter("feeinput").matches(venueFee)
                    ||!request.getParameter("placenameinput").matches(placeName)
                    ||!request.getParameter("addressinput").matches(address)
                    ||!request.getParameter("datetimeinput").matches(dateTime)
            ){
                request.setAttribute("message", "Illegal input value(s)...");
                return null;
            }

            Place place = new Place(
                    request.getParameter("placenameinput"),
                    request.getParameter("addressinput")
                    );
            PlaceDAO placeDAO = DAO.getDAO().place;

            List<Place> places = placeDAO.getAll(
                    String.format(" WHERE `Name`='%s' ;", place.getName())
            );

            if(places.size()>0){
                place = places.get(0);
            }

            placeDAO.create(place);

            Venue venue = new Venue(
                    request.getParameter("nameinput"),
                    request.getParameter("descriptioninput"),
                    Timestamp.valueOf(request.getParameter("datetimeinput")),
                    Float.parseFloat(request.getParameter("feeinput")),
                    1,
                    place.getId()
            );

            DAO.getDAO().venue.create(venue);

            return Action.LISTVENUES.command;
        }

        return null;
    }
}
