package by.it.korolchuk.project.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        process(req, resp) ;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        process(req, resp);
    }

    private void process (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String command = req.getParameter("command");
        String view = "/error.jsp";
        switch (command) {
            case  "Index":
                view = Actions.INDEX.JSP;
                break;
            case  "Login":
                view = Actions.LOGIN.JSP;
                break;
            case  "Logout":
                view = Actions.LOGOUT.JSP;
                break;
            case  "SignUp":
                view = Actions.SIGNUP.JSP;
                break;
            case  "CreateAd":
                view = Actions.CREATEAD.JSP;
                break;
            case  "ListAd":
                view = Actions.LISTAD.JSP;
                break;
        }
        resp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

        getServletContext().getRequestDispatcher(view).forward(req,resp);
    }


}
