package com.example.courseproject.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.courseproject.User.AuthResult;
import com.example.courseproject.User.Authorisotion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LogIn {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button log;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;
    @FXML
    private Text uncorrectAuthorisation;

    @FXML
    private Button reg;
    @FXML
    void log(MouseEvent event) {

    }

    @FXML
    void reg(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/courseproject/Reg.fxml"));
        Stage primaryStage = (Stage) reg.getScene().getWindow();
        primaryStage.setScene(new Scene(loader.load(), 700, 400));
        primaryStage.show();
    }

    @FXML
    void initialize() {
        log.setOnAction(event -> {
            String loginStr = login.getText();
            String passwordStr = password.getText();

            AuthResult authResult = Authorisotion.authenticateUser(loginStr, passwordStr);
            if (authResult.isAuthenticated()) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/courseproject/Menu.fxml"));
                    Stage primaryStage = (Stage) reg.getScene().getWindow();
                    primaryStage.setScene(new Scene(loader.load(), 700, 400));
                    primaryStage.show();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


                // Пользователь аутентифицирован, выполняйте необходимые действия
            } else {
                // Пользователь не найден, изменить прозрачность элемента uncorrectAuthorisation
                uncorrectAuthorisation.setOpacity(1.0);
            }
        });
    }

}
