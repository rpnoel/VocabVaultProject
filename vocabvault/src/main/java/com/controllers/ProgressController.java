package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import com.vocabvault.App;
import com.model.User;
import com.model.UserProgressTracker;
import com.model.VocabVaultFACADE;

public class ProgressController implements Initializable {
    @FXML
    Label usrLbl = new Label();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
       User currentUser = facade.currUser();
       UserProgressTracker usrProg = new UserProgressTracker(currentUser);
       usrLbl.setText(currentUser.getUsername());
    }

        @FXML
    private void clickBack(ActionEvent event) throws IOException {
        App.setRoot("home");
    }    
}
