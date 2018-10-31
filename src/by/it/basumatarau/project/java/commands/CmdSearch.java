package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.beans.Place;
import by.it.basumatarau.project.java.beans.Venue;
import by.it.basumatarau.project.java.controller.FormHandler;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CmdSearch extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response)throws SQLException, ParseException {

        if(FormHandler.isPost(request, response)){
            if(request.getParameter("searchSubmit")!=null) {
                String searchPattern = FormHandler.getString(request, "searchPattern");
                System.out.println(searchPattern);
                request.setAttribute("q", searchPattern);

                List<Venue> usrVenues = new ArrayList<>();
                List<Place> venuePlaces = new ArrayList<>();

                DAO.getDAO().venue.searchVenues(".*"+searchPattern+".*", usrVenues, venuePlaces);

                request.setAttribute("userVenues", usrVenues);
                request.setAttribute("venuePlaces", venuePlaces);
            }
        }

        return null;
    }
}
