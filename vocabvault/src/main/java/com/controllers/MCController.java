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
import com.narraration.Narriator;
import com.model.Question;
import com.model.User;
import com.model.UserProgressTracker;
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
    private Button playNarriator;
    @FXML
    private Label mcErrorLbl;
    @FXML
    private Label completeLbl;
    @FXML
    private Button okBtn;
    @FXML
    private Button nextBtn;
    private String userAnswer;
    private Question currQ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        currQ = facade.getQList().get((facade.getQNum()));
        System.out.println(facade.getQNum());
        setQuestion(currQ);
        facade.nextQuestion();
        completeLbl.setVisible(false);
        okBtn.setVisible(true);
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
    private void clickAudio(ActionEvent event) throws IOException {
        Narriator.playSound(currQ.toString());
    }

    @FXML
    private void checkAnswer(ActionEvent event) throws IOException {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        User currentUser = facade.currUser();
       UserProgressTracker usrProg = new UserProgressTracker(currentUser);
       Boolean corr = currQ.checkAnswer(userAnswer); 
       usrProg.logQuestion(currQ.getQText(), corr);
        if (currQ.checkAnswer(userAnswer)) {
            facade.getLevel().score(true);
            completeLbl.setText("Correct! Great job!");
            completeLbl.setVisible(true);
            okBtn.setVisible(false);
            nextBtn.setVisible(true);
        } else {
            facade.getLevel().score(false);
            completeLbl.setText("Incorrect. Try again!");
            completeLbl.setVisible(true);
            okBtn.setVisible(false);
            nextBtn.setVisible(true);
        }
    } 

    @FXML
    private void clickNext(ActionEvent event) throws IOException {
        App.setRoot("matching");
    }

    public static void main(String[] args) {
   
    }
}
