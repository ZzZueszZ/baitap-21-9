package DAO;

import model.User;

public interface IUserDao {
    User getUser(String username);
//    User login(String username, String password);
}
