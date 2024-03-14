package com.example.javafxtextcounterkotlin

import java.io.*
import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.FlowPane
import javafx.stage.FileChooser
import javafx.stage.Stage

class KotlinFileTextCounterJavaFX : Application() {
    @Throws(FileNotFoundException::class)
    override fun start(primaryStage: Stage) {
        val root = FlowPane()
        val scene = Scene(root, 480.0, 320.0) // set the application size to 480x320
        val selectFile = Button("Select file") // select the file from the dialog box
        primaryStage.scene = scene // set the scene
        primaryStage.title = "Text Counter Application" // set the title of stage
        val textCountResult =
                Label("Characters: 0\nWords: 0\nLines: 0") // set the default text counter output
        selectFile.onAction = EventHandler { event: ActionEvent? ->
            var textContent = "" // initialize empty text content string
            val fileChooser = FileChooser() // create a new file chooser
            fileChooser.title = "Select a file"
            fileChooser.extensionFilters.addAll(
                    FileChooser.ExtensionFilter("Text Files", "*.txt")
            ) // choose .txt text files
            val fileSelected = fileChooser.showOpenDialog(null) // show file dialog
            if (fileSelected != null) {
                try {
                    BufferedReader(FileReader(fileSelected)).use { reader ->
                        var line: String
                        while ((reader.readLine().also { line = it }) != null) {
                            textContent += line + "\n" // read text from a file every line
                        }
                    }
                } catch (e: IOException) {
                    throw RuntimeException(e) // throw runtime exception
                }
            }
            val chars: Int = textContent.length // get the length of opened text file in characters
            val words: Int =
                    textContent
                            .trim { it <= ' ' }
                            .split("\\s+".toRegex())
                            .dropLastWhile { it.isEmpty() }
                            .toTypedArray()
                            .size // get the length of opened text file in words
            val lines: Int =
                    textContent
                            .trim { it <= ' ' }
                            .split("\\r?\\n".toRegex())
                            .dropLastWhile { it.isEmpty() }
                            .toTypedArray()
                            .size // get the length of opened text file in lines
            textCountResult.text =
                    "Characters: " +
                            String.format("%,d", chars) +
                            "\nWords: " +
                            String.format("%,d", words) +
                            "\nLines: " +
                            String.format("%,d", lines) // update text counter output
        }
        root.children.addAll(selectFile, textCountResult) // add all components to the stage
        primaryStage.show() // show the stage
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(
                    KotlinFileTextCounterJavaFX::class.java
            ) // launch the application by running the program
        }
    }
}
