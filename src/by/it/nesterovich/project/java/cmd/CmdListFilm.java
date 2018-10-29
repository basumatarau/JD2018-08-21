package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.beans.Film;
import by.it.nesterovich.project.java.dao.Dao;
import by.it.nesterovich.project.java.utils.Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdListFilm extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        if (Form.isGet(req)) {
            Dao dao = Dao.getDao();

            List<Film> films = dao.film.getAll("");
            if (films.size() > 0) {
                req.setAttribute("films", films);
            }
        }
        return null;
    }
}
