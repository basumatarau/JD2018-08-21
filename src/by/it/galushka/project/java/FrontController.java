package by.it.galushka.project.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        process(req, resp);
    }

    private static ActionsResolver actionsResolver;

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Action action = actionsResolver.resolve(req);
        Cmd cmd = action.cmd;
        Cmd nextCmd = cmd.execute(req, resp);
        if (nextCmd==null) {
            String view = action.jsp;
            getServletContext().getRequestDispatcher(view).forward(req, resp);
        }
    }

    @Override
    public void init() throws ServletException {
        //actionResolver
    }
}
