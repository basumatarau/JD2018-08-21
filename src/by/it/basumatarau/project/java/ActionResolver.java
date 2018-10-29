package by.it.basumatarau.project.java;

import javax.servlet.http.HttpServletRequest;

public class ActionResolver {

    Action resolve(HttpServletRequest request){
        Action result = Action.ERROR;
        String command = request.getParameter("command");

        try {
            result = Action.valueOf(command.toUpperCase());
        }catch (IllegalArgumentException e){
            //error message
        }
        return result;
    }
}
