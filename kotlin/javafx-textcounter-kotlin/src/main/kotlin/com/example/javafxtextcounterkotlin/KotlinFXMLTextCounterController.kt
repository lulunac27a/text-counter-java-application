package com.example.javafxtextcounterkotlin

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea

class KotlinFXMLTextCounterController {
    @FXML var textContent: TextArea? = null
    @FXML var updateText: Button? = null
    @FXML var textCountResult: Label? = null
    fun calculateTextCount(actionEvent: ActionEvent?) { // when button is clicked
        val chars = textContent!!.length // get length of text area in characters
        val words =
                textContent!!
                        .text
                        .trim { it <= ' ' }
                        .split("\\s+".toRegex())
                        .dropLastWhile { it.isEmpty() }
                        .toTypedArray()
                        .size // get length of text area in words
        val lines =
                textContent!!
                        .text
                        .split("\\r?\\n".toRegex())
                        .dropLastWhile { it.isEmpty() }
                        .toTypedArray()
                        .size // get length of text area in lines
        textCountResult!!.text =
                "Characters: $chars\nWords: $words\nLines: $lines" // update text counter output
    }
}
