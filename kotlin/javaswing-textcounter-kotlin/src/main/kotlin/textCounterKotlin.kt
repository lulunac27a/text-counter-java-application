import java.awt.FlowLayout
import java.awt.Frame
import javax.swing.*

class textCounterKotlin {
  var textContent: JTextArea
  var updateText: JButton
  var textCountResult: JLabel

  init {
    val textCount: Frame =
        JFrame("Text Counter Application") // initialize frame and set title of frame
    textCount.layout = FlowLayout()
    textCount.setSize(480, 400) // set application size to 480x400
    textContent = JTextArea(10, 40) // create text area with 10 rows and 40 columns
    textCount.add(textContent) // add components to the frame
    updateText = JButton("Calculate text count")
    textCount.add(updateText)
    textCountResult =
        JLabel("Characters: 0\nWords: 0\nLines: 0") // set the default text counter output
    textCount.add(textCountResult)
    textCount.isVisible = true // make the frame visible
    updateText.addActionListener {
      // when the button is clicked
      val chars: Int = textContent.text.length // get the length of text area in characters
      val words: Int =
          textContent
              .text
              .trim { it <= ' ' }
              .split("\\s+".toRegex())
              .dropLastWhile { it.isEmpty() }
              .toTypedArray()
              .size // get the length of text area in words
      val lines: Int =
          textContent
              .text
              .split("\\r?\\n".toRegex())
              .dropLastWhile { it.isEmpty() }
              .toTypedArray()
              .size // get the length of text area in lines
      textCountResult.text =
          """
                    Characters: ${String.format("%,d", chars)}
                    Words: 
                    """.trimIndent() +
              String.format("%,d", words) +
              "\nLines: " +
              String.format("%,d", lines) // update text counter output
    }
  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SwingUtilities.invokeLater {
        textCounterKotlin() // launch the application by running the program
      }
    }
  }
}
