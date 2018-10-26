package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.beans.Film;
import by.it.nesterovich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdListFilm extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        if (req.getMethod().equalsIgnoreCase("get")) {
            Dao dao = Dao.getDao();

            List<Film> films = dao.film.getAll("");
            if (films.size() > 0) {
//                for (int i = 0; i < films.size(); i++) {
//                    req.setAttribute("films", films.get(i).getName());
//                }

                req.setAttribute("films", films);
            }

        }
        return null;
    }
}
