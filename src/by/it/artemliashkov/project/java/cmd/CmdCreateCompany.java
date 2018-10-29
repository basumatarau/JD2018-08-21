package by.it.artemliashkov.project.java.cmd;

import by.it.artemliashkov.project.java.beans.Company;
import by.it.artemliashkov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdCreateCompany extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        if (req.getMethod().equalsIgnoreCase("get")) {
            Dao dao = Dao.getDAO();

            List<Company> companies = dao.company.getAll("");
            System.out.println(companies);
            if (companies.size() > 0) {
                req.setAttribute("Company", companies);
            }
        }
        return null;
    }
}