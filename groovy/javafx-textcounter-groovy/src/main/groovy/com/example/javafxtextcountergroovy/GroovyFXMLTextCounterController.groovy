package com.example.javafxtextcountergroovy

import javafx.event.ActionEvent
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea

class GroovyFXMLTextCounterController {
    public TextArea textContent// text box area
    public Button updateText// button to update entered text from text box
    public Label textCountResult// text count output result

    void calculateTextCount(ActionEvent actionEvent) {// update text count result when button is clicked
        int chars = textContent.getLength()// get length of text area in characters
        int words = textContent.getText().trim().split("\\s+").length// get length of text area in words
        int lines = textContent.getText().split("\\r?\\n").length// get length of text area in lines
        textCountResult.setText("Characters: " + chars + "\nWords: " + words + "\nLines: " + lines)// update text count
                                                                                                // output
    }
}