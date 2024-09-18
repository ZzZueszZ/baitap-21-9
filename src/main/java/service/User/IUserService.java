package service.User;

import model.User;

public interface IUserService {
    User get(String username);
    User login(String username, String password);
}
