package by.it.bindyuk.project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdProfile extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (Form.isPost(req) && req.getParameter("logout") != null) {
            req.getSession().invalidate();
            return Action.LOGIN.cmd;
        }
        return null;
    }
}
