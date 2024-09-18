package DAO;

import model.User;

public interface IUserDao {
    User getUser(String username);
//    User login(String username, String password);
    void insert(User user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
}
