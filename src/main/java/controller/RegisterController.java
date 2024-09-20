package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.User.IUserService;
import service.User.UserServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    private IUserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl(); // Khởi tạo service
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Hiển thị form đăng ký
        req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // Lấy thông tin từ form
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String phone = req.getParameter("phone");
        int roleid = 2; // Ví dụ: mặc định vai trò là người dùng

        String alertMsg = "";

        // Kiểm tra thông tin
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty()) {
            alertMsg = "Tất cả các trường đều phải được điền.";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
            return;
        }

        // Kiểm tra mật khẩu
        if (!password.equals(confirmPassword)) {
            alertMsg = "Mật khẩu và xác nhận mật khẩu không khớp.";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
            return;
        }

        // Đăng ký người dùng
        boolean success = userService.register(email, username, password, roleid, phone);
        if (success) {
            // Đăng ký thành công, chuyển hướng tới trang đăng nhập
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            alertMsg = "Tên tài khoản, email hoặc số điện thoại đã tồn tại.";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
        }
    }

}
