package by.it.nesterovich.project.java.cmd;

import by.it.nesterovich.project.java.beans.Cinema;
import by.it.nesterovich.project.java.dao.Dao;
import by.it.nesterovich.project.java.utils.Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdListCinema extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isGet(req)) {
            Dao dao = Dao.getDao();
            //SELECT cinemas.name, cinemas.address FROM cinemas INNER JOIN films_cinemas ON films_cinemas.cinemas_id=cinemas.id INNER JOIN films ON films_cinemas.films_id=films.id WHERE films.id=2;
            List<Cinema> cinemas = dao.cinema.getAll(""); //подкоректировать список под конкретный фильм
            if (cinemas.size() > 0) {
                req.setAttribute("cinemas", cinemas);
            }
        }
        return null;    }
}
