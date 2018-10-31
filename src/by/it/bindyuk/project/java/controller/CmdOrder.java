package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.Ticket;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class CmdOrder extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isGet(req)) {
            Dao dao = Dao.getDao();
            List<Ticket> all = dao.ticket.getAll();
            req.setAttribute("transport", all.get(all.size() - 1).getTransport());
            req.setAttribute("from", dao.route.read(all.get(all.size() - 1).getRoutesIdFrom()).getCity());
            req.setAttribute("to", dao.route.read(all.get(all.size() - 1).getRoutesIdTo()).getCity());
            req.setAttribute("date", all.get(all.size() - 1).getData());
        }
        return null;
    }
}

