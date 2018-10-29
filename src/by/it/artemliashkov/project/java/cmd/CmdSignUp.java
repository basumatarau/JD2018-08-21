package by.it.artemliashkov.project.java.cmd;

import by.it.artemliashkov.project.java.Actions;
import by.it.artemliashkov.project.java.beans.Agent;
import by.it.artemliashkov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdSignUp extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String name = req.getParameter("name");
            String address = req.getParameter("address");
            Agent agent=new Agent(0,name,address,2);
            Dao dao=Dao.getDAO();
            dao.agent.create(agent);
            return Actions.LOGIN.cmd;
        }
        return null;
    }
}
