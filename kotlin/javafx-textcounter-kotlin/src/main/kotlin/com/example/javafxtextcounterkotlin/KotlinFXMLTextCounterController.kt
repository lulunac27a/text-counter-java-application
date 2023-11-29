package com.example.javafxtextcounterkotlin

import javafx.event.ActionEvent
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea

class KotlinFXMLTextCounterController {
        var textContent: TextArea? = null // text box area
        var updateText: Button? = null // button to update entered text from text box
        var textCountResult: Label? = null // text counter output result
        fun calculateTextCount(
                        actionEvent: ActionEvent?
        ) { // update text count result when button is clicked
                val chars = textContent!!.length // get length of text area in characters
                val words =
                                textContent!!.text
                                                .trim { it <= ' ' }
                                                .split("\\s+".toRegex())
                                                .dropLastWhile { it.isEmpty() }
                                                .toTypedArray()
                                                .size // get length of text area in words
                val lines =
                                textContent!!.text
                                                .split("\\r?\\n".toRegex())
                                                .dropLastWhile { it.isEmpty() }
                                                .toTypedArray()
                                                .size // get length of text area in lines
                textCountResult!!.text =
                                "Characters: $chars\nWords: $words\nLines: $lines" // update text
                // counter output
        }
}
