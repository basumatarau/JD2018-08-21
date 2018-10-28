package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.beans.ReservedTicket;
import by.it.nesterovich.project.java.dao.Dao;
import by.it.nesterovich.project.java.utils.Form;
import by.it.nesterovich.project.java.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdReservedTicket extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isGet(req)) {
            Dao dao = Dao.getDao();
            List<ReservedTicket> reservedTickets = dao.reservedTicket.getAll(" WHERE `users_id`=" + Utils.getUser(req).getId());
            if (reservedTickets.size() > 0) {
                req.setAttribute("reservedTickets", reservedTickets);
            }
        }
        return null;
    }
}
