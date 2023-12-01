package com.example.javafxtextcounter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TextCounterJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);// launch the application by running the program
    }

    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 480, 320);// set the application size to 480x320
        primaryStage.setScene(scene);// set the scene
        primaryStage.setTitle("Text Counter Application");// set title of stage
        TextArea textContent = new TextArea();// text box area
        Button updateText = new Button("Calculate text count");
        Label textCountResult = new Label("Characters: 0\nWords: 0\nLines: 0");// set to default text counter output
        updateText.setOnAction((event) -> {// calculate text count when button is clicked
            int chars = textContent.getLength();// get length of text area in characters
            int words = textContent.getText().trim().split("\\s+").length;// get length of text area in words
            int lines = textContent.getText().split("\\r?\\n").length;// get length of text area in lines
            textCountResult.setText("Characters: " + chars + "\nWords: " + words + "\nLines: " + lines);// update text
                                                                                                        // counter
                                                                                                        // output
        });
        root.getChildren().addAll(textContent, updateText, textCountResult);// add all components to the stage
        primaryStage.show();// show the stage
    }
}
