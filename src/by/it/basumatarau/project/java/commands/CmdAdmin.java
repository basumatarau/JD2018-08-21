package by.it.basumatarau.project.java.commands;

import by.it.basumatarau.project.java.beans.User;
import by.it.basumatarau.project.java.controller.Action;
import by.it.basumatarau.project.java.controller.FormHandler;
import by.it.basumatarau.project.java.controller.Util;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.http.Cookie;
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
            //todo administrator account permissions to be checked here...("user" is to be replaced by "admin")
        }else if(!DAO.getDAO().role.read(admin.getRoles_Id()).getRole().equalsIgnoreCase("user")){
            return Action.INDEX.command;
        }

        if(FormHandler.isPost(request, response)){
            String login = FormHandler.getString(request, "login");
            String email = FormHandler.getString(request, "email");
            Integer roles_id = FormHandler.getInt(request, "roles_id");
            String password = FormHandler.getString(request, "password");
            Long id = FormHandler.getLong(request, "id");

            User user = new User(
                    id,
                    login,
                    password,
                    email,
                    roles_id
            );

            if(request.getParameter("updateUser")!=null){
                if(DAO.getDAO().user.update(user)){
                    if(admin.getId()==user.getId()){
                        request.getSession(false).setAttribute("user", user);
                    }
                }
            }

            if(request.getParameter("deleteUser")!=null){
                if(DAO.getDAO().user.delete(user)){
                    if(admin.getId()==user.getId()){
                        request.getSession().removeAttribute("user");
                        response.addCookie(new Cookie("pwdHash",""));
                        request.getSession(false).invalidate();
                        return Action.LOGIN.command;
                    }
                }
            }
        }

        request.setAttribute("users", DAO.getDAO().user.getAll(""));
        request.setAttribute("roles", DAO.getDAO().role.getAll(""));

        return null;
    }
}
