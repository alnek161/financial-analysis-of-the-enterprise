package com.example.courseproject.Database.DAO.impl;

import com.example.courseproject.Database.DAO.UserDao;
import com.example.courseproject.Database.entity.User;
import com.example.courseproject.Database.sessionFacctory.SessionFactoryImpl;
import com.example.courseproject.Database.utils.SessionUtils;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
@NoArgsConstructor
public class UserDaoImpl implements UserDao {


    @Override
    public boolean addUser(User user) {
        return SessionUtils.saveEntity(user);
    }

    @Override
    public boolean updateUser(User user) {
        return SessionUtils.updateEntity(user);
    }

    @Override
    public boolean deleteUser(int userId) {
        return SessionUtils.deleteEntity(userId, User.class);
    }

    @Override
    public User getUserById(int userId) {
        return SessionUtils.find(User.class, userId, "idUser");
    }

    @Override
    public User getUserByName(String userName) {
        return SessionUtils.find(User.class, userName, "name");
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) SessionFactoryImpl.getSessionFactory().openSession().createQuery("From User").list();
    }
}
