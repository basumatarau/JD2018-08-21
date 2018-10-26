package by.it.bindyuk.project.java;

import javax.servlet.http.HttpServletRequest;

public class ActionResolver {

    Action resolve(HttpServletRequest req) {
        Action result = Action.ERROR; //по умолчанию do будет error
        String command = req.getParameter("command"); //получаем команду из request'a
        try {
            result = Action.valueOf(command.toUpperCase()); //вытаскиваем значение этой команды
        } catch (IllegalArgumentException e) {
            //result = Action.ERROR;
            //message to error.jsp
        }
        return result; // если все прошло успешно то вернем ее
    }

}
