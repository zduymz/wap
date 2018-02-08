package edu.mum.wap.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(filterName="authorization", urlPatterns = "/*")

public class Authorization implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest in = (HttpServletRequest)servletRequest;
        HttpServletResponse out = (HttpServletResponse)servletResponse;
        String uri = in.getRequestURI();
        if (uri.startsWith("/resources") ||
                uri.startsWith("/index") ||
                uri.startsWith("/movie") ||
                uri.startsWith("/showtime") ||
                uri.startsWith("/login") ||
                uri.startsWith("/logout") ||
                uri.startsWith("/register") ||
                uri.startsWith("/cinema") ) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            int count = (int) Arrays.stream(in.getCookies()).filter(c -> c.getName().equals("login_id")).count();
            String session = (String)in.getSession().getAttribute("username");
            if (count == 0 || session == null) {
                Cookie c = new Cookie("login_id","");
                c.setMaxAge(0);
                out.addCookie(c);
                out.sendRedirect("/index");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }
}
