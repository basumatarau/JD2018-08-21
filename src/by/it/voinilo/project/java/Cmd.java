package by.it.voinilo.project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Cmd {

   abstract Cmd execute (HttpServletRequest req, HttpServletResponse response);

    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        String cmd = name.replace("cmd", "");

        return cmd;
    }
}
