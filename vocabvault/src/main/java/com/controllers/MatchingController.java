package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.vocabvault.App;
import com.model.VocabVaultFACADE;
import com.model.Question;

public class MatchingController implements Initializable{
    @FXML
    private Label matchQuestionLbl = new Label();
    @FXML
    private RadioButton matchChoice1;
    @FXML
    private RadioButton matchChoice2;
    @FXML
    private RadioButton matchChoice3;
    @FXML
    private RadioButton matchChoice4;
    @FXML
    private Label mcErrorLbl;
    @FXML
    private Label completeLbl;
    @FXML
    private Button okBtn;
    @FXML
    private Button nextBtn;
    private String userAnswer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        Question currQ = facade.getLevel().getQuestion(facade.getQNum());
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
    private void clickChoice1(ActionEvent event) throws IOException {
        matchChoice1.setSelected(true);
        userAnswer = "1";
    }
    @FXML
    private void clickChoice2(ActionEvent event) throws IOException {
        matchChoice2.setSelected(true);
        userAnswer = "2";
    }
    @FXML
    private void clickChoice3(ActionEvent event) throws IOException {
        matchChoice3.setSelected(true);
        userAnswer = "3";
    }
    @FXML
    private void clickChoice4(ActionEvent event) throws IOException {
        matchChoice4.setSelected(true);
        userAnswer = "4";
    }

    @FXML
    private void checkAnswer(ActionEvent event) throws IOException {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        Question currQ = facade.iterateQuestions();
        if (currQ.checkAnswer(userAnswer)) {
            facade.getLevel().score(true);
            facade.incQNum();
            completeLbl.setVisible(true);
            okBtn.setVisible(false);
            nextBtn.setVisible(true);
        } else {
            facade.getLevel().score(false);
            facade.incQNum();
            completeLbl.setText("Incorrect. Try again!");
            completeLbl.setVisible(true);
            okBtn.setVisible(false);
            nextBtn.setVisible(true);
        }
    }
    @FXML
    private void clickNext(ActionEvent event) throws IOException {
        App.setRoot("multiplechoice");
    }
}