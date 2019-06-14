package servletclass;

import userdb.User;
import userdb.UserList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserList userList = new UserList();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        if(userList.isValidUser(username,password)){
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            if(remember != null){
                Cookie cookie = new Cookie("user",username);
                cookie.setMaxAge(30*24*60*60);
                resp.addCookie(cookie);
            }
            else{
                for (Cookie cookie : req.getCookies()) {
                    if (cookie.getName().equals("user")) {
                        cookie.setMaxAge(0);
                        resp.addCookie(cookie);
                    }
                }
            }
            Cookie cookie = new Cookie("promo","$100");
            cookie.setMaxAge(30*24*60*60);
            resp.addCookie(cookie);
            resp.sendRedirect("welcome.jsp");
            return;
        }
        resp.sendRedirect("/");
        req.setAttribute("error","Invalid username/password");
        System.out.println("Invalid");


    }
}
