package by.it.voinilo.project.java;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        process(req,resp);
    }


    private void process (HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        process(req,response);
        response.getWriter().print("C is alive");
        String command = req.getParameter("command");
            String view = "/error.jsp";
        switch (command){
            case "Index":
                view = Actions.INDEX.jsp;
            case "Login":
                view = Actions.LOGIN.jsp;
            case "Logout":
                view = Actions.LOGOUT.jsp;
            case "SignUp":
                view = Actions.SIGNUP.jsp;

    }
    getServletContext().getRequestDispatcher(view).forward(req,response);}

}
