package by.it.galushka.project.java;

import javax.servlet.http.HttpServletRequest;

public class ActionsResolver {

    Action resolve(HttpServletRequest req) {
        Action result = Action.ERROR;
        String command = req.getParameter("command");
        try {
            result = Action.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e){
//            result = Action.ERROR;
//            message to error.jsp
        }
        return result;
    }
}
