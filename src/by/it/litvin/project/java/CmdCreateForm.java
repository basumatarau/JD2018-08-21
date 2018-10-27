package by.it.litvin.project.java;

import by.it.litvin.project.java.dao.Dao;
import by.it.litvin.project.java.dao.beans.Form;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdCreateForm extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String address = req.getParameter("address");
            String description = req.getParameter("description");
            int age=Integer.parseInt(req.getParameter("age"));
            String information = req.getParameter("information");
            String aim = req.getParameter("aim");
            Form form=new Form(0,name,surname,address,description,age,
                    information,aim,2);
            Dao dao=Dao.getDao();
            dao.form.create(form);
        }
        return null;
    }
    }

