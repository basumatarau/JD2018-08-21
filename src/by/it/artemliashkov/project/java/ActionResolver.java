package by.it.artemliashkov.project.java;

import javax.servlet.http.HttpServletRequest;

public class ActionResolver {

    Actions resolver(HttpServletRequest req) {
        Actions result = Actions.ERROR;
        String command = req.getParameter("command");
        try {
            result = Actions.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
            //result = Action.ERROR;
            //message to error.jsp
        }
        return result;
    }

}
