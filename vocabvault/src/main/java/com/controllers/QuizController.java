package com.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.vocabvault.App;
import com.model.VocabVaultFACADE;
import com.model.BookReader;
import com.model.Question;

public class QuizController {
    private int qNum;

    @FXML
    public void clickPlay(ActionEvent event) throws IOException {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        qNum = facade.getQNum();
        if (qNum == 0) {
            facade.createLevel((new BookReader("vocabvault\\txt\\goldilocksESP.txt")).getBook());
        }
        if (qNum == 4 || qNum == 8 || qNum == 12) {
            //true false
            goTo("primary");
        } else if (qNum == 3 || qNum == 7 || qNum == 11) {
            //fitb
            goTo("primary");
        } else if (qNum == 2 || qNum == 6 || qNum == 10) {
            //matching
            goTo("matching");
        } else {
            goTo("multiplechoice");
        }
    }
    
    @FXML
    private void goTo(String type) {
        try {
            App.setRoot(type);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}