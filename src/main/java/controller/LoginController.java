package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Display the login page
        response.setContentType("text/html");
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean loginSuccess = false;

        // Validate username and password
        if (username != null && password != null && "admin".equals(username) && "admin".equals(password)) {
            loginSuccess = true;
        }

        if (loginSuccess) {
            req.setAttribute("username", username);
            req.setAttribute("msg", "Login successful!");
            // Redirect to home page on successful login
            req.getRequestDispatcher("/view/home.jsp").forward(req, resp);
        } else {
            // Handle failed login attempt
            req.setAttribute("msg", "Invalid username or password");
            req.getRequestDispatcher("/view/login.html").forward(req, resp);
        }
    }
}
