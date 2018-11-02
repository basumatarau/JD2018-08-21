package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.beans.Venue;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response)throws SQLException, ParseException {
        Long count = DAO.getDAO().venue.getCount("");
        request.setAttribute("count", count);
        return null;
    }
}
