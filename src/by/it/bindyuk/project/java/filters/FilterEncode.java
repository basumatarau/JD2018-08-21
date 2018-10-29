package by.it.bindyuk.project.java.filters;

import javax.servlet.*;
import java.io.IOException;

public class FilterEncode implements Filter {

    private String encode;

    @SuppressWarnings("all")
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("encode");
        System.out.println("FILTER INITIALIZATION: " + encode);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String characterEncoding = servletRequest.getCharacterEncoding();
        if (characterEncoding == null || !characterEncoding.equalsIgnoreCase(encode)) {
            servletRequest.setCharacterEncoding(encode);
        }

        characterEncoding = servletResponse.getCharacterEncoding();
        if (characterEncoding == null || !characterEncoding.equalsIgnoreCase(encode)) {
            servletResponse.setCharacterEncoding(encode);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        encode = null;
        System.out.println("FILTER HAS DESTROYED");
    }
}
