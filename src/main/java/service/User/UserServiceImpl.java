package service.User;

import DAO.IUserDao;
import DAO.UserDaoImpl;
import model.User;

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
    public void insert(User user) {

    }

    @Override
    public boolean register(String email, String password, String username, String fullname, String phone) {
        return false;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        return false;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return false;
    }

    public static void main(String[] args) throws SQLException {
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.get("exampleUser");
        System.out.println(user.getPassWord());
    }
}
