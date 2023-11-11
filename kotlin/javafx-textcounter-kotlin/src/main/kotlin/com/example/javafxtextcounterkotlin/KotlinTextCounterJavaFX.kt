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
        val scene = Scene(root, 480.0, 320.0)
        primaryStage.setScene(scene)
        primaryStage.title = "Text Counter Application"
        val textContent = TextArea()
        val updateText = Button("Calculate text count")
        val textCountResult = Label("Characters: 0\nWords: 0\nLines: 0")
        updateText.onAction = EventHandler { event: ActionEvent? ->
            val chars = textContent.length
            val words = textContent.text.trim { it <= ' ' }.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray().size
            val lines = textContent.text.split("\\r?\\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().size
            textCountResult.text = "Characters: $chars\nWords: $words\nLines: $lines"
        }
        root.children.addAll(textContent, updateText, textCountResult)
        primaryStage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(*args)
        }
    }
}
