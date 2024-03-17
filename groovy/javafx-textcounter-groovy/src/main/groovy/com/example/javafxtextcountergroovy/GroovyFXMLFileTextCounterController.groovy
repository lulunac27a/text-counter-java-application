package com.example.javafxtextcountergroovy

import javafx.event.ActionEvent
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.FileChooser

class GroovyFXMLFileTextCounterController {

    Button selectFile// button to select file
    Label textCountResult// text counter output result
    static BufferedReader reader = null// initialize reader
    String textContent = ''// initialize empty text content string

    void calculateTextCount(ActionEvent actionEvent) {
        String textContent = ''// initialize empty text content string
        FileChooser fileChooser = new FileChooser()// create a new file chooser
        fileChooser.title = 'Select a file'
        fileChooser.extensionFilters.addAll(new FileChooser.ExtensionFilter('Text Files', '*.txt'))// choose .txt
                                                                                                   // text files
        File fileSelected = fileChooser.showOpenDialog(null)// show file dialog
        if (fileSelected != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileSelected))) {
                String line
                while ((line = reader.readLine()) != null) {
                    textContent += line + '\n'// read text from file every line
                }
            } catch (IOException e) {
                throw new RuntimeException(e)// throw runtime exception
            }
        }
        int chars = textContent.length()// get the length of opened text file in characters
        int words = textContent.trim().split('\\s+').length// get the length of opened text file in words
        int lines = textContent.trim().split('\\r?\\n').length// get the length of opened text file in lines
        textCountResult.text = 'Characters: ' + String.format('%,d', chars) + '\nWords: ' + String.format('%,d', words)
        + '\nLines: ' + String.format('%,d', lines)// update text counter output
    }

}
