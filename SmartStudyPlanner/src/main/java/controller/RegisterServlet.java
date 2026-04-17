package controller;

import model.User;
import dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();

        System.out.println("Register request received: " + username);

        User user = new User(username, password);
        UserDAO dao = new UserDAO();

        boolean status = dao.registerUser(user);

        if (status) {
            System.out.println("User inserted successfully ✅");
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        } else {
            System.out.println("Insert failed ❌");
            response.sendRedirect(request.getContextPath() + "/jsp/register.jsp?error=1");
        }
    }
}