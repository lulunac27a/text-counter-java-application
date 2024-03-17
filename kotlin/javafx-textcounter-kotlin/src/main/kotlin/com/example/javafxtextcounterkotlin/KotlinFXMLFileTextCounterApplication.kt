package com.example.javafxtextcounterkotlin

import java.io.IOException
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class KotlinFXMLFileTextCounterApplication : Application() {
  @Throws(IOException::class)
  override fun start(stage: Stage) {
    val fxmlLoader =
        FXMLLoader(
            KotlinFXMLFileTextCounterApplication::class
                .java
                .getResource("kotlin-fxml-file-text-counter.fxml")) // load FXML file resource
    val scene = Scene(fxmlLoader.load(), 480.0, 320.0) // set application size to 480x320
    stage.title = "Text Counter from a File" // set the title of stage
    stage.scene = scene // set the stage to a scene
    stage.show() // show the stage
  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      launch(
          KotlinFXMLFileTextCounterApplication::class
              .java) // launch the application by running the program
    }
  }
}
