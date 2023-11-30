package com.example.courseproject.Database.DAO;

import com.example.courseproject.Database.entity.User;

import java.util.List;

public interface UserDao {
    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int userId);

    User getUserById(int userId);

    User getUserByName(String userName);

    List<User> getAllUsers();
}
