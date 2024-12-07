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
    @FXML
    Label totalLbl = new Label();
    @FXML
    Label correctLbl = new Label();
    @FXML
    Label accuracyLbl = new Label();
    @FXML
    Label langLbl = new Label();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
       User currentUser = facade.currUser();
       UserProgressTracker usrProg = new UserProgressTracker(currentUser);
       usrLbl.setText(currentUser.getUsername());  // Display username
       totalLbl.setText("Total Questions Answered: " + Integer.toString(currentUser.getTotalQuestionsAnswered()));  // Total questions answered
       correctLbl.setText("Correct Answers: " + Integer.toString(currentUser.getCorrectAnswers()));  // Correct answers
       accuracyLbl.setText("Accuracy: " + String.format("%.2f", usrProg.getAccuracy()) + "%");  // Accuracy (formatted as percentage)
       langLbl.setText("Current Language: Spanish"); 
    }

        @FXML
    private void clickBack(ActionEvent event) throws IOException {
        App.setRoot("home");
    }    
}
