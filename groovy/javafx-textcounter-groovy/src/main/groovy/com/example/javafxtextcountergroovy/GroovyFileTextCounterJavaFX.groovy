package com.example.javafxtextcountergroovy

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.FlowPane
import javafx.stage.FileChooser
import javafx.stage.Stage

class GroovyFileTextCounterJavaFX extends Application {

    static void main(String[] args) {
        launch(args)// launch the application by running the program
    }

    void start(Stage primaryStage) throws FileNotFoundException {
        FlowPane root = new FlowPane()
        Scene scene = new Scene(root, 480, 320)// set the application size to 480x320
        Button selectFile = new Button("Select file")// select the file from the dialog box
        primaryStage.setScene(scene)// set the scene
        primaryStage.setTitle("Text Counter Application")// set the title of stage
        Label textCountResult = new Label("Characters: 0\nWords: 0\nLines: 0")// set the default text counter output
        selectFile.setOnAction((event) -> {
            String textContent = ""// initialize empty text content string
            FileChooser fileChooser = new FileChooser()// create a new file chooser
            fileChooser.setTitle("Select a file")
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"))// choose
                                                                                                            // .txt
                                                                                                            // text
                                                                                                            // files
            File fileSelected = fileChooser.showOpenDialog(null)// show file dialog
            if (fileSelected != null) {
                try (BufferedReader reader = new BufferedReader(new FileReader(fileSelected))) {
                    String line
                    while ((line = reader.readLine()) != null) {
                        textContent += line + "\n"// read text from a file every line
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e)// throw runtime exception
                }
            }
            int chars = textContent.length()// get the length of opened text file in characters
            int words = textContent.trim().split("\\s+").length// get the length of opened text file in words
            int lines = textContent.trim().split("\\r?\\n").length// get the length of opened text file in lines
            textCountResult.setText("Characters: " + String.format("%,d", chars) + "\nWords: "
                    + String.format("%,d", words) + "\nLines: " + String.format("%,d", lines))// update text counter
                                                                                               // output
        })
        root.getChildren().addAll(selectFile, textCountResult)// add all components to the stage
        primaryStage.show()// show the stage
    }
}
