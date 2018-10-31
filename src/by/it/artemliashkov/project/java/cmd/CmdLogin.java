package by.it.artemliashkov.project.java.cmd;

import by.it.artemliashkov.project.java.beans.Agent;
import by.it.artemliashkov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdLogin extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        req.setAttribute("agent", "");
        if (req.getMethod().equalsIgnoreCase("post")) {
            String name = req.getParameter("name");
            String address = req.getParameter("address");
            Dao dao = Dao.getDAO();
            String where = String.format(" WHERE name='%s' AND address='%s'", name, address);
            List<Agent> agents = dao.agent.getAll(where);
            if (agents.size() > 0) {
                req.setAttribute("agent", agents.get(0));
            }
        }
        return null;
    }
}
