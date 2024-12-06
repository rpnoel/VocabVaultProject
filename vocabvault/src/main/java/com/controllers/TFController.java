package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.vocabvault.App;
import com.model.Question;
import com.model.VocabVaultFACADE;

public class TFController implements Initializable {
    @FXML
    private Label tfQuestionLbl = new Label();
    @FXML
    private Label completeLbl;
    @FXML
    private Button trueBtn;
    @FXML
    private Button falseBtn;
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
        tfQuestionLbl.setText(q.getQText());
        if (q.checkAnswer("true")) {

        }
    }

    @FXML
    private void clickTrue(ActionEvent event) {
        this.userAnswer = "true";
    }

    @FXML
    private void clickFalse(ActionEvent event) {
        this.userAnswer = "false";
    }

    @FXML
    private void checkAnswer(ActionEvent event) throws IOException {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        Question currQ = facade.iterateQuestions();
    
        if (currQ.checkAnswer(userAnswer)) {
            facade.getLevel().score(true);
            facade.incQNum();
            completeLbl.setText("Correct! Great job!");
            completeLbl.setVisible(true);
            nextBtn.setVisible(true);
        } else {
            facade.getLevel().score(false);
            facade.incQNum();
            completeLbl.setText("Incorrect. Try again!");
            completeLbl.setVisible(true);
            nextBtn.setVisible(true);
        }
    }

    @FXML
    private void clickNext(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
}