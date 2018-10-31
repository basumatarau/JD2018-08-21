package by.it.litvin.project.java;

import by.it.litvin.project.java.dao.Dao;
import by.it.litvin.project.java.dao.beans.Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdListForm extends Cmd {

    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("get")){
            Dao dao=Dao.getDao();
            List<Form> forms=dao.form.getAll("");
            if (forms.size()>0){
                req.setAttribute("forms",forms);
            }
        }
        return null;
    }
}
