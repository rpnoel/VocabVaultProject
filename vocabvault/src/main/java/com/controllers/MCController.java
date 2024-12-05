package com.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import com.vocabvault.App;
import com.model.VocabVaultFACADE;

public class MCController {
    @FXML
    private CheckBox mcChoice1;
    @FXML
    private CheckBox mcChoice2;
    @FXML
    private CheckBox mcChoice3;
    @FXML
    private CheckBox mcChoice4;

    @FXML
    private void checkChoice1(ActionEvent event) throws IOException {
        mcChoice1.setSelected(true);
    }
    @FXML
    private void checkChoice2(ActionEvent event) throws IOException {
        mcChoice2.setSelected(true);
    }
    @FXML
    private void checkChoice3(ActionEvent event) throws IOException {
        mcChoice3.setSelected(true);
    }
    @FXML
    private void checkChoice4(ActionEvent event) throws IOException {
        mcChoice4.setSelected(true);
    }
    @FXML
    private void checkAnswer(ActionEvent event) throws IOException {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
    } 
}
