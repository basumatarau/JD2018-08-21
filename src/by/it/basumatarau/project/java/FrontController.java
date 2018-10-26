package by.it.basumatarau.project.java;

import by.it.basumatarau.project.java.commands.Cmd;
import by.it.basumatarau.project.java.customDAO.DB_init;
import by.it.basumatarau.project.java.customDAO.DB_reset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FrontController extends HttpServlet {

    private ActionResolver resolver;

    @Override
    public void init() throws ServletException {
        //DB_init.createEmptyDB();
        DB_init.createDBplusInserts();
        this.resolver = new ActionResolver();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Action action = resolver.resolve(req);
        Cmd command = action.command;
        String view = action.jsp;
        Cmd nextCommand;

        try{
            nextCommand = command.execute(req, resp);
        }
        catch (Exception e){
            nextCommand = null;
            view = Action.ERROR.jsp;
            req.setAttribute("printStackTrace", e.toString());
        }

        if(nextCommand==null || nextCommand==command){
            getServletContext().getRequestDispatcher(view).forward(req, resp);
        }else{
            resp.sendRedirect("do?command="+nextCommand);
        }

        resp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
        resp.setHeader("Pragma", "no-cache");

    }

    @Override
    public void destroy() {
        DB_reset.resetDB();
    }
}
