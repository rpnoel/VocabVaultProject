package com.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.vocabvault.App;

public class SignupController {
    @FXML
    private void clickSignUp(ActionEvent event) throws IOException {
        //check user doesnt already exist
        //create user
        //log user in
        App.setRoot("home");
    } 
}
