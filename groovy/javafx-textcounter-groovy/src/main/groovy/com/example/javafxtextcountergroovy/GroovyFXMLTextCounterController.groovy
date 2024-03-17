package com.example.javafxtextcountergroovy

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea

class GroovyFXMLTextCounterController {

    @FXML
    public TextArea textContent// text box area
    @FXML
    public Button updateText// button to update entered text from text box
    @FXML
    public Label textCountResult// text counter output result
    @FXML
    void calculateTextCount(ActionEvent actionEvent) { // update text counter result when button is clicked
        int chars = textContent.length// get the length of text area in characters
        int words = textContent.text.trim().split('\\s+').length// get the length of text area in words
        int lines = textContent.text.split('\\r?\\n').length// get the length of text area in lines
        textCountResult.text = 'Characters: ' + String.format('%,d', chars) + '\nWords: ' + String.format('%,d', words) + '\nLines: ' + String.format('%,d', lines)// update text counter output
    }

}
