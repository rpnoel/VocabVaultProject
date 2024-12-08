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
import com.model.User;
import com.model.UserProgressTracker;
import com.model.VocabVaultFACADE;
import com.narraration.Narriator;

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
    @FXML
    private Button playNarriator;
    private String userAnswer;
    private Question currQ;
    private boolean corrAnswer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        currQ = facade.getQList().get((facade.getQNum()));
        setQuestion(currQ);
        facade.nextQuestion();
    }
    
    @FXML
    public void setQuestion(Question q) {
        tfQuestionLbl.setText(q.getQText());
        if (q.checkAnswer("true")) {
            corrAnswer = true;
        } else {
            corrAnswer = false;
        }
    }

    @FXML
    private void clickTrue(ActionEvent event) {
        this.userAnswer = "true";
        checkAnswer();
    }

    @FXML
    private void clickFalse(ActionEvent event) {
        this.userAnswer = "false";
        checkAnswer();
    }

    @FXML
    private void clickAudio(ActionEvent event) throws IOException {
        Narriator.playSound(currQ.toString());
    }


    private void checkAnswer() {
        //parse string to bool
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        User currentUser = facade.currUser();
       UserProgressTracker usrProg = new UserProgressTracker(currentUser);
       Boolean corr = currQ.checkAnswer(userAnswer); 
       usrProg.logQuestion(currQ.getQText(), corr);
        boolean userBool = Boolean.parseBoolean(userAnswer);
        if (userBool == corrAnswer) {
            facade.getLevel().score(true);
            completeLbl.setText("Correct! Great job!");
            completeLbl.setVisible(true);
            nextBtn.setVisible(true);
        } else {
            facade.getLevel().score(false);
            completeLbl.setText("Incorrect. Try again!");
            completeLbl.setVisible(true);
            nextBtn.setVisible(true);
        }
    }

    @FXML
    private void clickNext(ActionEvent event) throws IOException {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        if (facade.getQNum() == 11) {
            App.setRoot("progress");
        } else {
            App.setRoot("multiplechoice");
        }
    }
}