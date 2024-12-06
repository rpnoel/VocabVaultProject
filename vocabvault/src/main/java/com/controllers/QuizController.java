package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.vocabvault.App;
import com.model.VocabVaultFACADE;
import com.model.BookReader;
import com.model.Question;

public class QuizController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VocabVaultFACADE facade = VocabVaultFACADE.getInstance();
        facade.createLevel((new BookReader("vocabvault\\txt\\goldilocksESP.txt")).getBook());
        for (int i = 0; i < 12; i++) {
            if (i == 3 || i == 7 || i == 11) {
                //true false
            } else if (i == 2 || i == 6 || i == 10) {
                //fitb
            } else if (i == 1 || i == 5|| i == 9) {
                //matching
            } else {
                goTo("multiplechoice");
            }
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