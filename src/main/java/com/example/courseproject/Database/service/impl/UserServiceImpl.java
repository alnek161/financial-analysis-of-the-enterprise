package com.example.courseproject.Database.service.impl;

import com.example.courseproject.Database.DAO.UserDao;
import com.example.courseproject.Database.DAO.impl.UserDaoImpl;
import com.example.courseproject.Database.entity.Company;
import com.example.courseproject.Database.entity.User;
import com.example.courseproject.Database.service.UserService;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean addUser(User user) {
        boolean isAdded = false;
        try {
            userDao.addUser(user);
            isAdded = true;
        }
        catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateUser(User user) {
        boolean isUpdated = false;
        try {
            if(userDao.updateUser(user)) {
                isUpdated = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteUser(int userId) {
        boolean isDeleted = false;
        try {
            if(userDao.deleteUser(userId)) {
                isDeleted = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        try {
            user = userDao.getUserById(userId);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User getUserByName(String userId) {
        User user = null;
        try {
            user = userDao.getUserByName(userId);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            users = userDao.getAllUsers();
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
