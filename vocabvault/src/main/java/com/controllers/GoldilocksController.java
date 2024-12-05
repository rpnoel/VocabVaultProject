package com.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.Book;
import com.model.BookReader;
import com.vocabvault.App;

import java.util.ArrayList;

public class GoldilocksController implements Initializable {
    private BookReader reader = new BookReader("vocabvault\\txt\\goldilocksESP.txt");
    private String[] pageBook = reader.switchToPage();
    @FXML
    Pagination goldilocksPgn = new Pagination(8);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        goldilocksPgn.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                return createPage(pageIndex);
            }
        });
    }

    public VBox createPage(int pageIndex) {
        VBox element = new VBox(5);
        String currPage = pageBook[pageIndex];
        TextArea text = new TextArea(currPage);
        text.setWrapText(true);
        element.getChildren().add(text);
        return element;
    }

    @FXML
    private void clickBack(ActionEvent event) throws IOException {
        App.setRoot("library");
    }
}
