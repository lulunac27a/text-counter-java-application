package com.example.javafxtextcountergroovy

import javafx.event.ActionEvent
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.FileChooser

class GroovyFXMLFileTextCounterController {
    public Button selectFile// button to select file
    public Label textCountResult// text count output result
    static BufferedReader reader = null// initialize reader
    String textContent = ""// initalize empty text content string

    void calculateTextCount(ActionEvent actionEvent) {
        String textContent = ""// initalize empty text content string
        FileChooser fileChooser = new FileChooser()// create a new file chooser
        fileChooser.setTitle("Select a file")
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"))// choose .txt
                                                                                                        // text files
        File fileSelected = fileChooser.showOpenDialog(null)// show file dialog
        if (fileSelected != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileSelected))) {
                String line
                while ((line = reader.readLine()) != null) {
                    textContent += line + "\n"// read text from file every line
                }
            } catch (IOException e) {
                throw new RuntimeException(e)// throw runtime exception
            }
        }
        int chars = textContent.length()// get length of opened text file in characters
        int words = textContent.trim().split("\\s+").length// get length of opened text file in words
        int lines = textContent.trim().split("\\r?\\n").length// get length of opened text file in lines
        textCountResult.setText("Characters: " + chars + "\nWords: " + words + "\nLines: " + lines)// update text
                                                                                                // counter output
    }
}
