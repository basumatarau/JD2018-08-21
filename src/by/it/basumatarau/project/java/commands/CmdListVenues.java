package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.beans.Venue;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdListVenues extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response)throws SQLException, ParseException {
        String sqlStatement = "";

        List<Venue> allVenues = DAO.getDAO().venue.getAll(sqlStatement);

        request.setAttribute("venues", allVenues);

        return null;
    }
}
