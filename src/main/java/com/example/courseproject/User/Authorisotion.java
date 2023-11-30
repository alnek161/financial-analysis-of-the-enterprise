package com.example.courseproject.User;


import com.example.courseproject.Database.JDBС;
import com.example.courseproject.Database.entity.User;
import com.example.courseproject.Database.service.UserService;
import com.example.courseproject.Database.service.impl.UserServiceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authorisotion {


    public static void registerUser(String login, String password, String user) throws SQLException {

        UserService userService = new UserServiceImpl();

        User userObj = userService.getUserByName(login);
        if(userObj != null){
            System.out.println("Пользователь с логином '" + login + "' уже существует.");
        }
        String role;
        if (user.equals("user"))
        {
            role = "user";
        }else{
            role ="admin";
        }


        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User newUser = new User(login, hashedPassword, role);
        userService.addUser(newUser);
        System.out.println("Пользователь с логином '" + login + "' добавлен.");
    }


    public static AuthResult authenticateUser(String login, String password) {
        UserService userService = new UserServiceImpl();

        User userObj = userService.getUserByName(login);
        if(userObj == null){
            System.out.println("Пользователь с логином '" + login + "' не найден.");
            return new AuthResult(-1, false, "user");
        }
        int idUser = userObj.getIdUser();
        String role = userObj.getRole();
        String hashedPassword = userObj.getPassword();
        boolean isAuthenticated = BCrypt.checkpw(password, hashedPassword);
        return new AuthResult(idUser, isAuthenticated, role);
    }

}