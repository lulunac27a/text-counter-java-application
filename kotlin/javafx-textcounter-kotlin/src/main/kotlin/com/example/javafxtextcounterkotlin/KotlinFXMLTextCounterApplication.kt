package com.example.javafxtextcounterkotlin

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import java.io.IOException

class KotlinFXMLTextCounterApplication : Application() {
    @Throws(IOException::class)
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(KotlinFXMLTextCounterApplication::class.java.getResource("kotlin-fxml-text-counter.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 480.0)
        stage.title = "Text Counter"
        stage.setScene(scene)
        stage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(KotlinFXMLTextCounterApplication::class.java)
        }
    }
}