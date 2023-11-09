package com.example.javafxtextcounter;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLTextCounterController {
    public TextArea textContent;
    public Button updateText;
    public Label textCountResult;

    public void calculateTextCount(ActionEvent actionEvent) {
        int chars = textContent.getLength();
        int words = textContent.getText().trim().split("\\s+").length;
        int lines = textContent.getText().split("\\r?\\n").length;
        textCountResult.setText("Characters: " + chars + "\nWords: " + words + "\nLines: " + lines);
    }
}