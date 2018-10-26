package by.it.galushka.project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Cmd {

    abstract Cmd execute(HttpServletRequest req, HttpServletResponse resp);

    @Override
    public String toString() {
        String simpleName = this.getClass().getSimpleName();
        String cmd = simpleName.replace("Cmd", "");
        return cmd;
    }
}
