package by.it.bindyuk.project.java;

import by.it.bindyuk.project.java.dao.beans.Ticket;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdTickets extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Dao dao = Dao.getDao();
        List<Ticket> all = dao.ticket.getAll();
        if (all.size() > 0) {
            req.setAttribute("tickets", all.toString());
        }
        return null;
    }
}
