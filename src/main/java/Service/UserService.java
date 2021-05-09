package Service;

import Model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(int id);
    void removeUser(int id);
    void addUser(User user);
    void edit(User user);
}
