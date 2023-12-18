package com.example.javafxtextcounterkotlin

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import javafx.event.ActionEvent
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.FileChooser

class KotlinFXMLFileTextCounterController {
  var selectFile: Button? = null // button to select file
  var textCountResult: Label? = null // text counter output result
  var textContent = "" // initialize empty text content string

  fun calculateTextCount(actionEvent: ActionEvent?) {
    var textContent = "" // initialize empty text content string
    val fileChooser = FileChooser() // create a new file chooser
    fileChooser.title = "Select a file"
    fileChooser.extensionFilters.addAll(
        FileChooser.ExtensionFilter("Text Files", "*.txt")) // choose .txt text files
    val fileSelected = fileChooser.showOpenDialog(null) // show file dialog
    if (fileSelected != null) {
      try {
        BufferedReader(FileReader(fileSelected)).use { reader ->
          var line: String
          while (reader.readLine().also { line = it } != null) {
            textContent += line + "\n" // read text from file every line
          }
        }
      } catch (e: IOException) {
        throw RuntimeException(e) // throw runtime exception
      }
    }
    val chars = textContent.length // get length of opened text file in characters
    val words =
        textContent
            .trim { it <= ' ' }
            .split("\\s+".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray()
            .size // get length of opened text file in words
    val lines =
        textContent
            .trim { it <= ' ' }
            .split("\\r?\\n".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray()
            .size // get length of opened text file in lines
    textCountResult!!.text =
        "Characters: $chars\nWords: $words\nLines: $lines" // update text counter output
  }

  companion object {
    var reader: BufferedReader? = null // initialize reader
  }
}
