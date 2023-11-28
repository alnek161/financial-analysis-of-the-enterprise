package com.example.courseproject.Database.service;

import com.example.courseproject.Database.entity.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);

    User getUserById(int userId);

    User getUserByName(String userName);

    List<User> getAllUsers();
}
