package by.it.voinilo.project.java;

import by.it.voinilo.project.java.beans.Roleparam;
import by.it.voinilo.project.java.entitydao.Dao;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin extends Cmd {
  @Override

    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {


      if (req.getMethod().equalsIgnoreCase("post")) {

          String login = req.getParameter("login");
          String password = req.getParameter("password");
          Dao dao = Dao.getDao();
          String where = String.format(" WHERE `login`='%s' AND `password`='%s'",login,password);
          List<Roleparam> users = dao.user.getALL(where);
          if (users.size()>0) {
              req.setAttribute("user",users.get(0));
          }

      }
      return null;
  }

    public static void main(String[] args) throws SQLException {
        String where = String.format(" WHERE `login`='%s' AND `password`='%s'","a","c");
        List<Roleparam> all = Dao.getDao().user.getALL(where);
        System.out.println(all.get(0));

}

}
