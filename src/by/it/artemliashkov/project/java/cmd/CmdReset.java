package by.it.artemliashkov.project.java.cmd;

import by.it.artemliashkov.project.java.Actions;
import by.it.artemliashkov.project.java.utils.Database;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdReset extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        Database.resetAndCreateDBWithTables();
        return Actions.INDEX.cmd;
    }
}