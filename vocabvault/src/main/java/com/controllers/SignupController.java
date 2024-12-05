package com.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import com.vocabvault.App;
import com.model.VocabVaultFACADE;

public class SignupController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label errorLbl = new Label();
   
    @FXML
    private void clickSignUp(ActionEvent event) throws IOException {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        if (facade.login(username.getText(), password.getText())) {
            this.errorLbl.setVisible(true);
        } else {
            facade.add(username.getText(), email.getText(), firstName.getText(), lastName.getText(), password.getText());
            App.setRoot("home");
        }
    }
    @FXML
    private void clickBack(ActionEvent event) throws IOException {
        App.setRoot("start");
    }
}
