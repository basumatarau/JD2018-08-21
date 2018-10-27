package by.it.artemliashkov.project.java;

import by.it.artemliashkov.project.java.cmd.Cmd;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    private ActionResolver actionResolver;

    @Override
    public void init() throws ServletException {
        actionResolver = new ActionResolver();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Actions action = actionResolver.resolver(req);
        Cmd command = action.cmd;
        String view = action.getJsp();
        Cmd nextCommand;
        try {
            nextCommand = command.execute(req, resp);
        } catch (Exception e) {
            nextCommand = null;
            view = Actions.ERROR.getJsp();
            req.setAttribute("printStackTrace", e.toString());
        }
        if (nextCommand == null || nextCommand == command) {
            getServletContext().getRequestDispatcher(view).forward(req, resp);
        } else {
            resp.sendRedirect("do?command=" + nextCommand.toString());
        }
    }
}
