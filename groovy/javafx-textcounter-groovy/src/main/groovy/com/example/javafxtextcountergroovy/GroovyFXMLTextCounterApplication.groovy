package com.example.javafxtextcountergroovy

import groovy.transform.CompileStatic
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

import java.io.IOException

@CompileStatic
class GroovyFXMLTextCounterApplication extends Application {

    static void main(String[] args) {
        launch()// launch the application by running the program
    }
    @Override
    void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GroovyFXMLTextCounterApplication.class.getResource('fxml-text-counter-groovy.fxml'))// load
                                                                                                                                   // FXML
                                                                                                                                   // file
                                                                                                                                   // resource
        Scene scene = new Scene(fxmlLoader.load() as Parent, 480, 400)// set application size to 480x400
        stage.title = 'Text Counter'// set the title of stage
        stage.scene = scene// set the stage to a scene
        stage.show()// show the stage
    }

}
