package by.it.galushka.project.java;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {


    private ActionsResolver actionsResolver;

    @Override
    public void init(ServletConfig config) throws ServletException {
        actionsResolver = new ActionsResolver();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Action action = actionsResolver.resolve(req);
        Cmd command = action.cmd;
        String view = action.getJsp();
        Cmd nextCommand;
        try {
            nextCommand = command.execute(req, resp);
        } catch (Exception e) {
            nextCommand = null;
            view = Action.ERROR.getJsp();
            req.setAttribute("printStackTrace", e.toString());
        }
        if (nextCommand == null || nextCommand == command) {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(view);
            requestDispatcher.forward(req,resp);
        } else
            resp.sendRedirect("do?command=" + nextCommand.toString());

    }
}
