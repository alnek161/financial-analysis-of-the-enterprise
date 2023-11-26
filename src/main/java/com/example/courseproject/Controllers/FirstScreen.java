package com.example.courseproject.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FirstScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button reg;

    @FXML
    private Button sign;


    @FXML
    void initialize() {
//        assert reg != null : "fx:id=\"reg\" was not injected: check your FXML file 'FirstScreen.fxml'.";
//        assert sign != null : "fx:id=\"sign\" was not injected: check your FXML file 'FirstScreen.fxml'.";

    }

    @FXML
    void reg(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/courseproject/Reg.fxml"));
        Stage primaryStage = (Stage) reg.getScene().getWindow();
        primaryStage.setScene(new Scene(loader.load(), 700, 400));
        primaryStage.show();
    }

    @FXML
    void sign(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/courseproject/logIn.fxml"));
        Stage primaryStage = (Stage) sign.getScene().getWindow();
        primaryStage.setScene(new Scene(loader.load(), 700, 400));
        primaryStage.show();
    }

}
