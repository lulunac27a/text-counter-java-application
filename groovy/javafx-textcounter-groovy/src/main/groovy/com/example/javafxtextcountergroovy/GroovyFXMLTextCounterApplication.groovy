package com.example.javafxtextcountergroovy

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

import java.io.IOException

 class GroovyFXMLTextCounterApplication extends Application {
    @Override
    void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                com.example.javafxtextcountergroovy.GroovyFXMLTextCounterApplication.class
                        .getResource("fxml-text-counter-groovy.fxml"))// load FXML file resource
        Scene scene = new Scene(fxmlLoader.load(), 480, 320)// set application size to 480x320
        stage.setTitle("Text Counter")// set title of stage
        stage.setScene(scene)// set stage to scene
        stage.show()// show the stage
    }

    static void main(String[] args) {
        launch(GroovyFXMLTextCounterApplication.class, args)// launch the application by running the program
    }
}