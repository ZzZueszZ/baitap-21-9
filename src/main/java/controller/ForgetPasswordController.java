package controller;


import java.io.IOException;
import java.util.UUID;

import DAO.IUserDao;
import DAO.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User.IUserService;

@WebServlet("/forgot-password")
public class ForgetPasswordController extends HttpServlet {
    IUserDao UserDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Render view forget-password.jsp
        request.getRequestDispatcher("/view/forget-password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String alertMessage;

//        IUserDao UserDao = new UserDaoImpl();
        // Kiểm tra xem email có tồn tại trong hệ thống hay không
        // Đây là ví dụ, bạn cần thay thế bằng mã kiểm tra email trong cơ sở dữ liệu của bạn
        boolean emailExists = UserDao.checkExistEmail(email);

        if (emailExists) {
            // Tạo mật khẩu mới
            String newPassword = UUID.randomUUID().toString().substring(0, 8); // Tạo mật khẩu ngẫu nhiên

            // Cập nhật mật khẩu mới trong cơ sở dữ liệu
            updatePasswordInDatabase(email, newPassword);

            alertMessage = "Thành công! Mật khẩu mới của bạn là:" + newPassword;
        }
        else {
            alertMessage = "Email không tồn tại trong hệ thống.";
        }
        // Set the alert message as a request attribute and forward to the view
        request.setAttribute("alertMessage", alertMessage);
        request.getRequestDispatcher("/view/forget-password.jsp").forward(request, response);

     


    }

    private void updatePasswordInDatabase(String email, String newPassword) {
        UserDao.updatePassword(email, newPassword);
    }

}
