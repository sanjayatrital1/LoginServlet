package javafilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getContextPath()+"/login";

        boolean isLoggedIn = session !=null && session.getAttribute("username") != null;
        boolean loggedInRequest = request.getRequestURI().equals(uri) || request.getRequestURI().equals("/");

        if(isLoggedIn || loggedInRequest){
            filterChain.doFilter(request,response);
        }
        else {
            response.sendRedirect("/");
            request.setAttribute("error","Invalid username/password");
        }
    }

    @Override
    public void destroy() {

    }
}
