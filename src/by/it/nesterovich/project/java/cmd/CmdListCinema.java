package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.beans.Cinema;
import by.it.nesterovich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdListCinema extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("get")) {
            Dao dao = Dao.getDao();

            List<Cinema> cinemas = dao.cinema.getAll(""); //подкоректировать список под конкретный фильм
            if (cinemas.size() > 0) {
                req.setAttribute("cinemas", cinemas);
            }
        }
        return null;    }
}
