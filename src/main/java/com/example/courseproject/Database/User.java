package com.example.courseproject.Database;

import javafx.beans.property.SimpleStringProperty;

public class User {
    private final SimpleStringProperty login;
    private final SimpleStringProperty role;


    public User(String login, String role) {
        this.login = new SimpleStringProperty(login);
        this.role = new SimpleStringProperty(role);

    }

    public String getLogin() {
        return login.get();
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getRole() {
        return role.get();
    }

    public void setRole(String role) {
        this.role.set(role);
    }


    public SimpleStringProperty loginProperty() {
        return login;
    }

    public SimpleStringProperty roleProperty() {
        return role;
    }

}
