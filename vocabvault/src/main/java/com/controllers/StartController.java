package com.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.vocabvault.App;

public class StartController {

    @FXML
    private void clickLogIn(ActionEvent event) throws IOException {
        App.setRoot("login");
    }
    @FXML
    private void clickSignUp(ActionEvent event) throws IOException {
        App.setRoot("signup");
    }
}
