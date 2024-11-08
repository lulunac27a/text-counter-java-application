package com.example.javafxtextcounter;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLFileTextCounterApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(
        FXMLFileTextCounterApplication.class.getResource(
            "fxml-file-text-counter.fxml")); // load FXML file resource
    Scene scene = new Scene(fxmlLoader.load(), 480, 400); // set application size to 480x400
    stage.setTitle("Text Counter from a File"); // set the title of stage
    stage.setScene(scene); // set the stage to a scene
    stage.show(); // show the stage
  }

  public static void main(String[] args) {
    launch(); // launch the application by running the program
  }
}
