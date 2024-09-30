package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }
        clearRememberMeCookie(response); // Clear remember me cookie
        response.sendRedirect(request.getContextPath() + "/view/login.jsp"); // Redirect to login page
    }

    private void clearRememberMeCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("rememberMe", null);
        cookie.setMaxAge(0); // Xóa cookie
        cookie.setPath("/"); // Đặt đường dẫn để xóa trên toàn bộ ứng dụng
        response.addCookie(cookie);
    }
}

