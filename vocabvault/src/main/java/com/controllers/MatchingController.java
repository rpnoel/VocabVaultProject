package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import com.vocabvault.App;
import com.model.VocabVaultFACADE;
import com.model.Question;
import com.model.MultipleChoice;

public class MatchingController implements Initializable{
    @FXML
    Label matchQuestionLbl = new Label();
    @FXML
    private CheckBox matchChoice1;
    @FXML
    private CheckBox matchChoice2;
    @FXML
    private CheckBox matchChoice3;
    @FXML
    private CheckBox matchChoice4;
    @FXML
    private Label mcErrorLbl;
    private String userAnswer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        Question currQ = facade.getLevel().getQuestion(2);
        setQuestion(currQ);
    }

    @FXML
    public void setQuestion(Question q) {
        matchQuestionLbl.setText(q.getQText());
        ArrayList<String> choices = new ArrayList<String>();
        choices = q.returnChoices();
        matchChoice1.setText(choices.get(0));
        matchChoice2.setText(choices.get(1));
        matchChoice3.setText(choices.get(2));
        matchChoice4.setText(choices.get(3));
    }

    @FXML
    private void checkChoice1(ActionEvent event) throws IOException {
        matchChoice1.setSelected(true);
        userAnswer = "1";
        matchChoice2.setSelected(false);
        matchChoice3.setSelected(false);
        matchChoice4.setSelected(false);
    }
    @FXML
    private void checkChoice2(ActionEvent event) throws IOException {
        matchChoice2.setSelected(true);
        userAnswer = "2";
        matchChoice1.setSelected(false);
        matchChoice3.setSelected(false);
        matchChoice4.setSelected(false);
    }
    @FXML
    private void checkChoice3(ActionEvent event) throws IOException {
        matchChoice3.setSelected(true);
        userAnswer = "3";
        matchChoice1.setSelected(false);
        matchChoice2.setSelected(false);
        matchChoice4.setSelected(false);
    }
    @FXML
    private void checkChoice4(ActionEvent event) throws IOException {
        matchChoice4.setSelected(true);
        userAnswer = "4";
        matchChoice1.setSelected(false);
        matchChoice2.setSelected(false);
        matchChoice3.setSelected(false);
    }

    @FXML
    private void checkAnswer(ActionEvent event) throws IOException {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        Question currQ = facade.iterateQuestions();
        if (currQ.checkAnswer(userAnswer)) {
            facade.getLevel().score(true);
            App.setRoot("correctanswer");
        } else {
            facade.getLevel().score(false);
            App.setRoot("wrongAnswer");
        }
    } 
}