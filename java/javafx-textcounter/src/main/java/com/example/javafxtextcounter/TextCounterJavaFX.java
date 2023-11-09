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
        launch(args);
    }


    public void start(Stage primaryStage) {
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 480, 320);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Text Counter Application");
        TextArea textContent = new TextArea();
        Button updateText = new Button("Calculate text count");
        Label textCountResult = new Label("Characters: 0\nWords: 0\nLines: 0");
        updateText.setOnAction((event) -> {
            int chars = textContent.getLength();
            int words = textContent.getText().trim().split("\\s+").length;
            int lines = textContent.getText().split("\\r?\\n").length;
            textCountResult.setText("Characters: " + chars + "\nWords: " + words + "\nLines: " + lines);
        });
        root.getChildren().addAll(textContent,updateText,textCountResult);
        primaryStage.show();
    }
}
