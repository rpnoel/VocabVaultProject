package com.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import com.vocabvault.App;
import com.model.VocabVaultFACADE;
import com.model.UserList;

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
    private PasswordField password;
    @FXML
    private Label errorLbl = new Label();
   
    @FXML
    private void clickSignUp(ActionEvent event) throws IOException {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        UserList newList = UserList.getInstance();
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
