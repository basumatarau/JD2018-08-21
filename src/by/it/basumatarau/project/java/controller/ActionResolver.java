package by.it.basumatarau.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class ActionResolver {

    Action resolve(HttpServletRequest request){
        Action result = Action.ERROR;
        String command = request.getParameter("command");
        if(command==null){
            request.setAttribute("printStackTrace", "illegal argument error");
            return result;
        }
        try {
            result = Action.valueOf(command.toUpperCase());
        }catch (IllegalArgumentException e){
            request.setAttribute("printStackTrace", e.toString());
        }
        return result;
    }
}
