package com.virus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SuccessController {
    @FXML
    private Parent root;

    public void handleButtonAction(ActionEvent event) throws IOException {
        Scene scene;
        Stage stage = (Stage) root.getScene().getWindow();
        scene = new Scene(FXMLLoader.load(getClass().getResource("MainPage.fxml")));

        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle("Ransomware");
        stage.show();
    }
}
