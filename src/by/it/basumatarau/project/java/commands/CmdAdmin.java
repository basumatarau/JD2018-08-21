package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.beans.User;
import by.it.basumatarau.project.java.controller.Action;
import by.it.basumatarau.project.java.controller.FormHandler;
import by.it.basumatarau.project.java.controller.Util;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdAdmin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ParseException {

        User admin = Util.getUser(request);
        if(admin==null){
            return Action.LOGIN.command;
        }else if(!DAO.getDAO().role.read(admin.getRoles_Id()).getRole().equalsIgnoreCase("user")){
            return Action.INDEX.command;
        }

        if(FormHandler.isPost(request, response)){
            String login = FormHandler.getString(request, "login");
            String email = FormHandler.getString(request, "email");
            Integer roles_id = FormHandler.getInt(request, "roles_id");
            Long id = FormHandler.getLong(request, "id");
            String password = FormHandler.getString(request, "password");


            User user = new User(
                    id,
                    login,
                    password,
                    email,
                    roles_id
            );
            if(request.getParameter("updateUser")!=null){
                DAO.getDAO().user.update(user);
            }
            if(request.getParameter("deleteUser")!=null){
                DAO.getDAO().user.delete(user);
            }
        }

        request.setAttribute("users", DAO.getDAO().user.getAll(""));
        request.setAttribute("roles", DAO.getDAO().role.getAll(""));

        return null;
    }
}
