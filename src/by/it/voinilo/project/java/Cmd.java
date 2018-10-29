package by.it.voinilo.project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Cmd {

   abstract Cmd execute (HttpServletRequest req, HttpServletResponse response) throws  Exception;

    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        String cmd = name.replace("Cmd", "");

        return cmd;

    }


}
