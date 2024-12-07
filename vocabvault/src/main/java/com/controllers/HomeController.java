package com.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.vocabvault.App;
import com.model.VocabVaultFACADE;

public class HomeController {

    @FXML
    private void clickRead(ActionEvent event) throws IOException {
        App.setRoot("library");
    }

    @FXML
    private void clickQuiz(ActionEvent event) throws IOException {
        App.setRoot("multiplechoice");
    }

    @FXML
    private void clickProgress(ActionEvent event) throws IOException {
        App.setRoot("progress");
    }

    @FXML
    private void clickLogOut(ActionEvent event) throws IOException {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        facade.logout();
        App.setRoot("start");
    }
}
