package service.User;

import DAO.IUserDao;
import DAO.UserDaoImpl;
import controller.db.DBConnectionMySql;
import model.User;

import java.sql.Date;
import java.sql.SQLException;

public class UserServiceImpl implements IUserService{
    UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public User get(String username) {
        return userDao.getUser(username);
    }

    @Override
    public User login(String username, String password) {
        User user = this.get(username);
        if (user != null && password.equals(user.getPassWord())) {
            return user;
        }
        return null;
    }
    @Override
    public boolean register(String email, String username, String password, int roleid, String phone) {
        // Kiểm tra sự tồn tại của tên tài khoản, email và số điện thoại
        if (userDao.checkExistUsername(username) || userDao.checkExistEmail(email) || userDao.checkExistPhone(phone)) {
            return false; // Nếu đã tồn tại thì không thực hiện đăng ký
        }

        // Tạo đối tượng User
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setUserName(username);
        newUser.setPassWord(password); // Nên mã hóa mật khẩu
        newUser.setAvatar("null"); // Thay đổi nếu cần
        newUser.setRoleid(roleid);
        newUser.setPhone(phone);
        newUser.setCreatedDate(new Date(System.currentTimeMillis())); // Ngày tạo

        // Chèn người dùng vào cơ sở dữ liệu
        userDao.insert(newUser);
        return true;
    }




    public static void main(String[] args) throws SQLException {
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.get("exampleUser");
        System.out.println(user.getPassWord());
    }
}
