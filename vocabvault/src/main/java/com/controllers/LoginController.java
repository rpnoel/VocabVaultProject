package com.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.vocabvault.App;

public class LoginController {
    @FXML
    private void clickLogin(ActionEvent event) throws IOException {
        //check for sucessful login
        App.setRoot("home");
    }
    @FXML
    private void clickBack(ActionEvent event) throws IOException {
        App.setRoot("start");
    }
}
