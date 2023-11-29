package com.example.javafxtextcountergroovy

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class GroovyFXMLFileTextCounterApplication extends Application {
    @Override
    void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                GroovyFXMLFileTextCounterApplication.class.getResource("fxml-file-text-counter.fxml"))// load FXML file
                                                                                                    // resource
        Scene scene = new Scene(fxmlLoader.load() as Parent, 480, 320)// set application size to 480x320
        stage.setTitle("Text Counter from a File")// set title of stage
        stage.setScene(scene)// set stage to scene
        stage.show()// show the stage
    }

    static void main(String[] args) {
        launch(GroovyFXMLFileTextCounterApplication.class, args)// launch the application by running the program
    }
}
