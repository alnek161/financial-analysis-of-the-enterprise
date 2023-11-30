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
            if(userService != null){
                System.out.println("Пользователь с логином '" + login + "' уже существует.");
            }
            User userObj = userService.getUserByName(login);
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

        JDBС.close();
    }

    private static boolean isUserExists(String login) throws SQLException {
        String sql = "SELECT COUNT(*) FROM `User` WHERE `name` = ?";
        PreparedStatement statement = JDBС.connection.prepareStatement(sql);
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0;
        }
        return false;
    }
    public static AuthResult authenticateUser(String login, String password) {
        try {
            JDBС.connect();  // Установить соединение с базой данных

            String query = "SELECT idUser, password, role FROM user WHERE name = ?"; // Добавить role в запрос
            PreparedStatement statement = JDBС.connection.prepareStatement(query);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idUser = resultSet.getInt("idUser");
                String hashedPassword = resultSet.getString("password");
                String role = resultSet.getString("role"); // Получить роль из результата
                boolean isAuthenticated = BCrypt.checkpw(password, hashedPassword);

                JDBС.close();

                return new AuthResult(idUser, isAuthenticated, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new AuthResult(-1, false, "user");
    }

}