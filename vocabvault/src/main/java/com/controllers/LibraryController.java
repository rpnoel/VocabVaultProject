package com.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import com.model.VocabVaultFACADE;
import com.vocabvault.App;

public class LibraryController {
    @FXML
    private void clickGoldilocks(ActionEvent event) throws IOException {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        App.setRoot("goldilocks");
    }

    @FXML
    private void clickBack(ActionEvent event) throws IOException {
        App.setRoot("home");
    }
}