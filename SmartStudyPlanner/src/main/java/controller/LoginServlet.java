package controller;

import model.User;
import dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String username = request.getParameter("username").trim();
    	String password = request.getParameter("password").trim();
        User user = new User(username, password);
        UserDAO dao = new UserDAO();

        if (dao.validateUser(user)) {

            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            // Redirect to planner
            response.sendRedirect("jsp/index.jsp");
            

        } else {
            // Login failed
            response.sendRedirect("jsp/login.jsp?error=1");
        }
    }
}