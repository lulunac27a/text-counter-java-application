package com.example.javafxtextcounterkotlin

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.layout.FlowPane
import javafx.stage.Stage

class KotlinTextCounterJavaFX : Application() {
        override fun start(primaryStage: Stage) {
                val root = FlowPane()
                val scene = Scene(root, 480.0, 320.0) // set the application size to 480x320
                primaryStage.setScene(scene) // set the scene
                primaryStage.title = "Text Counter Application" // set title of stage
                val textContent = TextArea()
                val updateText = Button("Calculate text count")
                val textCountResult =
                                Label(
                                                "Characters: 0\nWords: 0\nLines: 0"
                                ) // set to default text counter output
                updateText.onAction =
                                EventHandler { event: ActionEvent?
                                        -> // calculate text count when button is clicked
                                        val chars = textContent.length // get length of text
                                        // area in characters
                                        val words =
                                                        textContent.text
                                                                        .trim { it <= ' ' }
                                                                        .split("\\s+".toRegex())
                                                                        .dropLastWhile {
                                                                                it.isEmpty()
                                                                        }
                                                                        .toTypedArray()
                                                                        .size // get length of text
                                        // area in words
                                        val lines =
                                                        textContent.text
                                                                        .split("\\r?\\n".toRegex())
                                                                        .dropLastWhile {
                                                                                it.isEmpty()
                                                                        }
                                                                        .toTypedArray()
                                                                        .size // get length of text
                                        // area in lines
                                        textCountResult.text =
                                                        "Characters: $chars\nWords: $words\nLines: $lines" // update text count
                                        // output
                                }
                root.children.addAll(
                                textContent,
                                updateText,
                                textCountResult
                ) // add all components to the stage
                primaryStage.show() // show the stage
        }

        companion object {
                @JvmStatic
                fun main(args: Array<String>) {
                        launch(
                                        KotlinTextCounterJavaFX::class.java
                        ) // launch the application by running the program
                }
        }
}
