package by.it.bindyuk.project.java;

import by.it.bindyuk.project.java.dao.beans.Route;
import by.it.bindyuk.project.java.dao.beans.Ticket;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

public class CmdTicket extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            Dao dao = Dao.getDao();
            List<Route> all = dao.route.getAll();
            String transport = Form.getString(req, "transport", Patterns.TRANSPORT);
            String from = Form.getString(req, "from", Patterns.CITY);
            long fromTrue = 0;

            // т.к. маршруты это отдельная таблица со списком городов, узнаем какой город ввел пользователь,
            //сравниваем его со всеми городами и узнаем его id, после создавая готовый билет

            for (Route route : all) {
                if (route.getCity().equals(from)) {
                    fromTrue = route.getId();
                }
            }

            String to = Form.getString(req, "to", Patterns.CITY);
            long toTrue = 0;
            for (Route route : all) {
                if (route.getCity().equals(to)) {
                    toTrue = route.getId();
                }
            }
            Timestamp when = Timestamp.valueOf(req.getParameter("when"));
            Ticket ticket = new Ticket(0, transport, fromTrue, toTrue, when, 2);
            dao.ticket.create(ticket);
            return Action.ORDER.cmd;
        }
        return null;
    }
}
