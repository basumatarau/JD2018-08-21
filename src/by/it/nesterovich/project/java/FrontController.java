package by.it.nesterovich.project.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        String view = "/error.jsp";
        //resp.setHeader("Cache-Control", "no-store, no-cache");

        switch (command) {
            case "Index": {
                view = Actions.INDEX.jsp;
                break;
            }
            case "Login": {
                view = Actions.LOGIN.jsp;
                break;
            }
            case "SignUp": {
                view = Actions.SIGNUP.jsp;
                break;
            }
            case "Logout": {
                view = Actions.LOGOUT.jsp;
                break;
            }
            case "CreateFilm": {
                view = Actions.CREATEFILM.jsp;
                break;
            }
            case "ListFilm": {
                view = Actions.LISTFILM.jsp;
                break;
            }
        }
        resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setDateHeader("Last-Modified", new Date().getTime());

        getServletContext().getRequestDispatcher(view).forward(req, resp);
    }
}
