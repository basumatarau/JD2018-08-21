package by.it.bindyuk.project.java;

import javax.servlet.http.HttpServletRequest;

public class AcitonResolver {

    Action resolve(HttpServletRequest req) {
        Action result = Action.ERROR;
        String command = req.getParameter("command");
        try {
            result = Action.valueOf(command.toUpperCase());
        }catch (IllegalArgumentException e){
            result = Action.ERROR;
            //msg to error.jsp
        }
        return result;
    }

}
