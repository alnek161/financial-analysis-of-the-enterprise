package com.example.courseproject.Controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.courseproject.User.Authorisotion;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class Reg {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Text fieldDanger;
    @FXML
    private Text passwordDanger;
    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password2;

    @FXML
    private Button register;

//    @FXML
//    void register(MouseEvent event) {
//
//    }

    @FXML
    void initialize() {
//        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'Reg.fxml'.";
//        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Reg.fxml'.";
//        assert password2 != null : "fx:id=\"password2\" was not injected: check your FXML file 'Reg.fxml'.";
//        assert register != null : "fx:id=\"register\" was not injected: check your FXML file 'Reg.fxml'.";
        register.setOnAction(event -> {
            String loginStr = login.getText();
            String passwordStr = password.getText();
            String repeatPassword = password2.getText();

            boolean isFieldsEmpty = loginStr.isEmpty() || passwordStr.isEmpty() || repeatPassword.isEmpty();
            boolean isPasswordsMatch = passwordStr.equals(repeatPassword);

            if (isFieldsEmpty) {
                passwordDanger.setOpacity(0);
                fieldDanger.setOpacity(1);
            } else if (!isPasswordsMatch) {
                fieldDanger.setOpacity(0);
                passwordDanger.setOpacity(1);
            } else {
                fieldDanger.setOpacity(0);
                passwordDanger.setOpacity(0);
                fieldDanger.setText("");
                passwordDanger.setText("");
                try {
                    Authorisotion.registerUser(loginStr, passwordStr, "admin");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                login.setText("");
                password.setText("");
                password2.setText("");
            }
        });
    }

}
