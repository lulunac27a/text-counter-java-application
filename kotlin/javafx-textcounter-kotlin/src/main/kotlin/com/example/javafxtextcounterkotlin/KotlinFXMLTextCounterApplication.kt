package com.example.javafxtextcounterkotlin

import java.io.IOException
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class KotlinFXMLTextCounterApplication : Application() {
  @Throws(IOException::class)
  override fun start(stage: Stage) {
    val fxmlLoader =
        FXMLLoader(
            KotlinFXMLTextCounterApplication::class.java.getResource(
                "kotlin-fxml-text-counter.fxml"
            )
        ) // load FXML file resource
    val scene = Scene(fxmlLoader.load(), 480.0, 400.0) // set application size to 480x400
    stage.title = "Text Counter" // set the title of stage
    stage.scene = scene // set the stage to a scene
    stage.show() // show the stage
  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      launch(
          KotlinFXMLTextCounterApplication::class.java
      ) // launch the application by running the program
    }
  }
}
