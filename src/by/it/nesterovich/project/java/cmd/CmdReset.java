package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.Action;
import by.it.nesterovich.project.java.ulils.DataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdReset extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        DataBase.resetAndCreateDBWithTables();
        DataBase.InitTables();
        return Action.INDEX.cmd;
    }
}
