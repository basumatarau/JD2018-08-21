package by.it.akhmelev.project6.java.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class FilterEncoding implements Filter {

    String encode;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("encode");
        System.out.println("Filter init. encode="+encode);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String characterEncoding = req.getCharacterEncoding();
        if (characterEncoding == null || !characterEncoding.equalsIgnoreCase(encode))
            req.setCharacterEncoding(encode);

        characterEncoding = resp.getCharacterEncoding();
        if (characterEncoding == null || !characterEncoding.equalsIgnoreCase(encode))
            resp.setCharacterEncoding(encode);

        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
