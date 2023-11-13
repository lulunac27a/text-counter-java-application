package com.example.javafxtextcounter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLTextCounterApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FXMLTextCounterApplication.class.getResource("fxml-text-counter.fxml"));// load
                                                                                                                       // FXML
                                                                                                                       // file
                                                                                                                       // resource
        Scene scene = new Scene(fxmlLoader.load(), 480, 320);// set application size to 480x320
        stage.setTitle("Text Counter");// set title of stage
        stage.setScene(scene);// set stage to scene
        stage.show();// show the stage
    }

    public static void main(String[] args) {
        launch();// launch the application by running the program
    }
}