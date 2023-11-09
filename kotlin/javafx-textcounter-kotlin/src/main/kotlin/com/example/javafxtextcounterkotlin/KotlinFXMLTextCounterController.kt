package com.example.javafxtextcounterkotlin

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea

class KotlinFXMLTextCounterController {
    @FXML
    var textContent: TextArea? = null
    @FXML
    var updateText: Button? = null
    @FXML
    var textCountResult: Label? = null
    fun calculateTextCount(actionEvent: ActionEvent?) {
        val chars = textContent!!.length
        val words = textContent!!.text.trim { it <= ' ' }.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray().size
        val lines = textContent!!.text.split("\\r?\\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().size
        textCountResult!!.text = "Characters: $chars\nWords: $words\nLines: $lines"
    }
}