package by.it.akhmelev.project7.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionResolver {

    Action resovle(HttpServletRequest req) {
        Action result = Action.ERROR;

        String command = req.getParameter("command");
        if (command == null) return Action.INDEX;

        try {
            Action action = Action.valueOf(command.toUpperCase());
            req.getServletContext().log("RESOLVE:" + action.cmd.toString());
            result = Action.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
            //result = Action.ERROR;
            //message to error.jsp
        }
        return result;
    }

}
