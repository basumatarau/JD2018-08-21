package by.it.voinilo.project.java;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FrontController extends HttpServlet {
    ActionResolver actionResolver;

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


    private void process(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        Action action = actionResolver.resolve(req);
        Cmd command = action.cmd;
        Cmd nextCommand;
        String view = action.getJsp;
        try {

            nextCommand= command.execute(req, response);
        } catch (Exception e) {
            nextCommand=null;
            view= Action.ERROR.getJsp;
        }
       if (nextCommand == null || nextCommand==command) {
           response.setHeader("Cache-Control", "no-store, no-cache");
            getServletContext().getRequestDispatcher(view).forward(req, response);
        }
        else
            response.sendRedirect("do?command="+ nextCommand.toString());

    }


}
