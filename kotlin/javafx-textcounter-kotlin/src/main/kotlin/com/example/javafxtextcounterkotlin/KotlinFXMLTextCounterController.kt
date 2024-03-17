package com.example.javafxtextcounterkotlin

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea

class KotlinFXMLTextCounterController {
        @FXML var textContent: TextArea? = null // text box area
        @FXML var updateText: Button? = null // button to update entered text from text box
        @FXML var textCountResult: Label? = null // text counter output result

        fun calculateTextCount(
                        actionEvent: ActionEvent?
        ) { // update a text count result when button is clicked
                val chars: Int = textContent!!.length // get the length of text area in characters
                val words: Int =
                                textContent!!.text
                                                .trim { it <= ' ' }
                                                .split("\\s+".toRegex())
                                                .dropLastWhile { it.isEmpty() }
                                                .toTypedArray()
                                                .size // get the length of text area in words
                val lines: Int =
                                textContent!!.text
                                                .split("\\r?\\n".toRegex())
                                                .dropLastWhile { it.isEmpty() }
                                                .toTypedArray()
                                                .size // get the length of text area in lines
                textCountResult!!.text =
                                """
             Characters: ${String.format("%,d", chars)}
             Words: ${String.format("%,d", words)}
             Lines: ${String.format("%,d", lines)}
             """.trimIndent() // update text counter output
        }
}
