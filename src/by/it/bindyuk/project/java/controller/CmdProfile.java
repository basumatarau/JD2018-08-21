package by.it.bindyuk.project.java.controller;

import by.it.bindyuk.project.java.dao.beans.Ticket;
import by.it.bindyuk.project.java.dao.beans.User;
import by.it.bindyuk.project.java.dao.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

class CmdProfile extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUser(req);
        if (user == null) {
            return Action.LOGIN.cmd;
        }
        if (Form.isPost(req) && req.getParameter("logout") != null) {
            HttpSession session = req.getSession();
            session.invalidate();
            return Action.LOGIN.cmd;
        }
        List<Ticket> tickets = Dao.getDao().ticket.getAll(" WHERE `tickets`.`users_id`=" + user.getId());
        HttpSession session = req.getSession();
        session.setAttribute("ticket", tickets);
        return null;
    }
}
