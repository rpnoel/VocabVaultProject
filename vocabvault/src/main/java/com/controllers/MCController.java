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

public class MCController implements Initializable{
    @FXML
    Label questionLbl = new Label();
    @FXML
    private CheckBox mcChoice1;
    @FXML
    private CheckBox mcChoice2;
    @FXML
    private CheckBox mcChoice3;
    @FXML
    private CheckBox mcChoice4;
    @FXML
    private Label mcErrorLbl;
    private String userAnswer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        Question currQ = facade.getLevel().getQuestion(1);
        setQuestion(currQ);
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
    private void checkChoice1(ActionEvent event) throws IOException {
        mcChoice1.setSelected(true);
        userAnswer = "1";
        mcChoice2.setSelected(false);
        mcChoice3.setSelected(false);
        mcChoice4.setSelected(false);
    }
    @FXML
    private void checkChoice2(ActionEvent event) throws IOException {
        mcChoice2.setSelected(true);
        userAnswer = "2";
        mcChoice1.setSelected(false);
        mcChoice3.setSelected(false);
        mcChoice4.setSelected(false);
    }
    @FXML
    private void checkChoice3(ActionEvent event) throws IOException {
        mcChoice3.setSelected(true);
        userAnswer = "3";
        mcChoice1.setSelected(false);
        mcChoice2.setSelected(false);
        mcChoice4.setSelected(false);
    }
    @FXML
    private void checkChoice4(ActionEvent event) throws IOException {
        mcChoice4.setSelected(true);
        userAnswer = "4";
        mcChoice1.setSelected(false);
        mcChoice2.setSelected(false);
        mcChoice3.setSelected(false);
    }

    private void setUserAnswer() {
        if (mcChoice1.isSelected()) {
            userAnswer = "01";
        } else if (mcChoice2.isSelected()) {
            userAnswer = "02";
        } else if (mcChoice3.isSelected()) {
            userAnswer = "03";
        } else if (mcChoice4.isSelected()) {
            userAnswer = "04";
        } else {
            mcErrorLbl.setVisible(true);
            setUserAnswer();
        }
    }

    @FXML
    private void checkAnswer(ActionEvent event) throws IOException {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        Question currQ = facade.iterateQuestions();
        setUserAnswer();
        if (currQ.checkAnswer(userAnswer)) {
            facade.getLevel().score(true);
            facade.incQNum();
            App.setRoot("correctanswer");
        } else {
            facade.getLevel().score(false);
            facade.incQNum();
            App.setRoot("wrongAnswer");
        }
    } 

    public static void main(String[] args) {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        Question currQ = facade.getLevel().getQuestion(1);
        ArrayList<String> choices = new ArrayList<String>();
        choices = currQ.returnChoices();
        for (String s : choices) {
            System.out.println(s);
        }
    }
}
