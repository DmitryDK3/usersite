package Dao;

import Model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User getUser(int id);
    void removeUser(int id);
    void addUser(User user);
    void edit(User user);
   User getUserByName(String s);
}

