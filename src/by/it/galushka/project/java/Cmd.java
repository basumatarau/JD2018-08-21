package by.it.galushka.project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

abstract class Cmd {

    abstract Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException;

    @Override
    public String toString() {
        String simpleName = this.getClass().getSimpleName();
        String cmd = simpleName.replace("Cmd", "");

        return cmd;
    }
}
