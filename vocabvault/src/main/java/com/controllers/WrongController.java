package com.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.vocabvault.App;

public class WrongController {
    @FXML
    private void clickNext(ActionEvent event) throws IOException {
        App.setRoot("quiz");
    }
}