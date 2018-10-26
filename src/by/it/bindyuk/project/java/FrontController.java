package by.it.bindyuk.project.java;

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
        //process(req, resp);
        Action action = actionResolver.resolve(req);
        try {
            action.cmd.execute(req, resp);
            getServletContext().getRequestDispatcher(action.getJsp()).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = actionResolver.resolve(req);  //вытаскисваем значение команды
        Cmd command = action.cmd;                     //получаем экземпляр класса Action и инициализируем его как команду
        String view = action.getJsp();                //вьюшка , которую мы будем показывать в браузере (в зависимости от типа команды)
        Cmd nextCommand;                              //команда для выполнения после актуальной
        try {
            nextCommand = command.execute(req, resp);
        } catch (Exception e) {
            nextCommand = null;
            view = Action.ERROR.getJsp();
            req.setAttribute("printStackTrace", e.toString());
        }
        if (nextCommand == null || nextCommand == command) {
            //resp.setHeader("Cache-Control", "no-cache");
            getServletContext().getRequestDispatcher(view).forward(req, resp);
        } else {
            resp.sendRedirect("do?command=" + nextCommand.toString());
        }
    }
}

