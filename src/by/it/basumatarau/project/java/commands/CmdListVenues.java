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

public class CmdListVenues extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException {

        int itmesPerPage = 10;
        int startPage = 1;
        if (request.getParameter("startPage") != null) {
            startPage = FormHandler.getInt(request, "startPage");
        }

        Long count = DAO.getDAO().venue.getCount("");

        if(startPage<1||startPage-1>count/itmesPerPage){
            startPage=1;
        }

        List<Venue> usrVenues = new ArrayList<>();
        List<Place> venuePlaces = new ArrayList<>();

        String sqlQuery = String.format(" LIMIT %s,10 ", (startPage-1)*10);
        DAO.getDAO().venue.getAllDetailed(sqlQuery, usrVenues, venuePlaces);

        request.setAttribute("venues", usrVenues);
        request.setAttribute("venuePlaces", venuePlaces);

        request.setAttribute("itemsPerPage", itmesPerPage);
        request.setAttribute("totalCount", count);
        request.setAttribute("currentPage", startPage);

        return null;
    }
}
