package com.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.vocabvault.App;
import com.model.VocabVaultFACADE;

public class QuizController {
    @FXML
    private void clickPlay(ActionEvent event) throws IOException {
        App.setRoot("play");
    }
}