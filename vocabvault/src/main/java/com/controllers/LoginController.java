package com.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import com.vocabvault.App;
import com.model.VocabVaultFACADE;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label errorLbl = new Label();

    @FXML
    private void clickLogIn(ActionEvent event) throws IOException {
        String user = username.getText();
        String pass = password.getText();
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        if (!(facade.login(user, pass))) {
            errorLbl.setVisible(true);
        } else {
            facade.login(user, pass);
            App.setRoot("home");
        }
    }
    @FXML
    private void clickBack(ActionEvent event) throws IOException {
        App.setRoot("start");
    }
}
