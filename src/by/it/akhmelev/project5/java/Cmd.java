package by.it.akhmelev.project5.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

abstract class Cmd {

    abstract Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception;

    @Override
    public String toString() {
        String name=this.getClass().getSimpleName();
        String cmd = name.replace("Cmd", "");
        return cmd;
    }
}
