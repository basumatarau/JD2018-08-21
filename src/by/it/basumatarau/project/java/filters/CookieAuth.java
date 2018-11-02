package by.it.basumatarau.project.java.filters;

import by.it.basumatarau.project.java.beans.User;
import by.it.basumatarau.project.java.controller.Action;
import by.it.basumatarau.project.java.controller.Util;
import by.it.basumatarau.project.java.customDAO.DAO;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class CookieAuth implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        retriveSession((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private static void retriveSession(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = Util.getUser(request);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(30 * 30);
            return;
        }

        String usrID = null;
        String digest = null;

        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userID")) {
                usrID = cookie.getValue();
            }
            if (cookie.getName().equals("pwdHash")) {
                digest = cookie.getValue();
            }
        }

        if (usrID != null && digest != null) {
            try {
                user = DAO.getDAO().user.read(Long.parseLong(usrID));
                if (user == null) {
                    return;
                }
                String digestPwd = Util.getPwdHash(user.getPassword(), user.getEmail());

                if (digestPwd.equals(digest)) {
                    request.getSession().setMaxInactiveInterval(30 * 30);
                    request.getSession().setAttribute("user", user);
                }

            } catch (SQLException e) {
                request.setAttribute("printStackTrace", "resolver: " + e.toString());
                request.getServletContext().getRequestDispatcher(Action.ERROR.jsp).forward(request, response);
            }

        }
    }

    @Override
    public void destroy() {

    }
}
