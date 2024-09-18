package service.User;

import DAO.IUserDao;
import DAO.UserDaoImpl;
import model.User;

public class UserServiceImpl implements IUserService{
    IUserDao userDao = new UserDaoImpl();
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
}
