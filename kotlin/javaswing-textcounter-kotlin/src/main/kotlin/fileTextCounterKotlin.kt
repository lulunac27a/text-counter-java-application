import java.awt.FlowLayout
import java.awt.Frame
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import javax.swing.*

class fileTextCounterKotlin {
  private var selectFile = JButton("Select file")
  private var textCountResult: JLabel

  init {
    val textCount: Frame =
        JFrame("File Text Counter Application") // initialize frame and set title of frame
    textCount.setLayout(FlowLayout())
    textCount.setSize(480, 320) // set application size to 480x320
    textCount.add(selectFile) // add components to the frame
    textCountResult =
        JLabel("Characters: 0\nWords: 0\nLines: 0") // set the default text counter output
    textCount.add(textCountResult)
    textCount.isVisible = true // make the frame visible
    selectFile.addActionListener(
        object : ActionListener {
          override fun actionPerformed(e: ActionEvent) { // when button is clicked
            val fileChooser = JFileChooser() // create a new file chooser
            val fileResult = fileChooser.showOpenDialog(textCount) // show file dialog
            val textContent: String
            textContent =
                try {
                  getTextContent(fileResult, fileChooser)
                } catch (ex: IOException) {
                  throw RuntimeException(ex)
                }
            val chars = textContent.length // get length of text area in characters
            val words =
                textContent
                    .trim { it <= ' ' }
                    .split("\\s+".toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray()
                    .size // get length of text area in words
            val lines =
                textContent
                    .split("\\r?\\n".toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray()
                    .size // get length of text area in lines
            textCountResult.setText(
                "Characters: $chars\nWords: $words\nLines: $lines") // update text count output
          }

          @Throws(IOException::class)
          private fun getTextContent(fileResult: Int, fileChooser: JFileChooser): String {
            var textContent = "" // initialize empty text content string
            if (fileResult == JFileChooser.APPROVE_OPTION) {
              val filePath = fileChooser.selectedFile.path // get the file path
              BufferedReader(FileReader(filePath)).use { reader ->
                var line: String
                while (reader.readLine().also { line = it } != null) {
                  textContent += line + "\n" // read text from a file every line
                }
              }
            }
            return textContent
          }
        })
  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SwingUtilities.invokeLater {
        fileTextCounterKotlin() // launch the application by running the program
      }
    }
  }
}
