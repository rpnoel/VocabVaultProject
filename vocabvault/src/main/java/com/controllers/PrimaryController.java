package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.vocabvault.App;
import com.narraration.*;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        Narriator.playSound("¡Hola Mundo!");
        App.setRoot("secondary");
    }
}
