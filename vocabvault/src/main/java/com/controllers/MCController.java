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
import com.model.MultipleChoice;

public class MCController implements Initializable{
    @FXML
    Label questionLbl = new Label();
    @FXML
    private RadioButton mcChoice1;
    @FXML
    private RadioButton mcChoice2;
    @FXML
    private RadioButton mcChoice3;
    @FXML
    private RadioButton mcChoice4;
    @FXML
    private Label mcErrorLbl;
    @FXML
    private Label completeLbl;
    @FXML
    private Button okBtn;
    private String userAnswer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        Question currQ = facade.iterateQuestions();
        setQuestion(currQ);
        completeLbl.setVisible(false);
        if (facade.getQNum() != 0) {
            facade.incQNum();
        }
    }

    @FXML
    public void setQuestion(Question q) {
        questionLbl.setText(q.getQText());
        ArrayList<String> choices = new ArrayList<String>();
        choices = q.returnChoices();
        mcChoice1.setText(choices.get(0));
        mcChoice2.setText(choices.get(1));
        mcChoice3.setText(choices.get(2));
        mcChoice4.setText(choices.get(3));
    }

    @FXML
    private void clickChoice1(ActionEvent event) throws IOException {
        mcChoice1.setSelected(true);
        userAnswer = "1";
    }
    @FXML
    private void clickChoice2(ActionEvent event) throws IOException {
        mcChoice2.setSelected(true);
        userAnswer = "2";
    }
    @FXML
    private void clickChoice3(ActionEvent event) throws IOException {
        mcChoice3.setSelected(true);
        userAnswer = "3";
    }
    @FXML
    private void clickChoice4(ActionEvent event) throws IOException {
        mcChoice4.setSelected(true);
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
        } else {
            facade.getLevel().score(false);
            facade.incQNum();
            completeLbl.setText("Incorrect. Try again!");
            completeLbl.setVisible(true);
        }
    } 

    public static void main(String[] args) {
   
    }
}
