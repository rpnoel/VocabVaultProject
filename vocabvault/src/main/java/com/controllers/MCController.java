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
    private int corrAnswer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        Question currQ = facade.getQuestion(facade.getLevel(), 1);
        setQuestion(currQ);
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
        corrAnswer = 0;
    }
    @FXML
    private void checkChoice2(ActionEvent event) throws IOException {
        mcChoice2.setSelected(true);
        corrAnswer = 1;
    }
    @FXML
    private void checkChoice3(ActionEvent event) throws IOException {
        mcChoice3.setSelected(true);
        corrAnswer = 2;
    }
    @FXML
    private void checkChoice4(ActionEvent event) throws IOException {
        mcChoice4.setSelected(true);
        corrAnswer = 3;
    }
    @FXML
    private void checkAnswer(ActionEvent event) throws IOException {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        Question currQ = facade.getLevel().getQuestion(1);
        if (currQ.checkAnswer(Integer.toString(corrAnswer))) {
            facade.getLevel().score(true);
            App.setRoot("correctanswer");
        } else {
            //App.setRoot("wrongAnswer");
        }
    } 
}
