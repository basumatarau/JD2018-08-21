package by.it.basumatarau.project.java.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdReset extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response)throws SQLException {
        return null;
    }
}
