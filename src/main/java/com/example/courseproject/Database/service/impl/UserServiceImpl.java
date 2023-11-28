package com.example.courseproject.Database.DAO.impl;

import com.example.courseproject.Database.DAO.UserDao;
import com.example.courseproject.Database.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(int userId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, userId);
        if (user != null) {
            session.delete(user);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public User getUserById(int userId) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, userId);
        session.close();
        return user;
    }

    @Override
    public User getUserByName(String userName) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM User WHERE name = :name", User.class);
        query.setParameter("name", userName);
        User user = query.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM User", User.class);
        List<User> userList = query.list();
        session.close();
        return userList;
    }
}
