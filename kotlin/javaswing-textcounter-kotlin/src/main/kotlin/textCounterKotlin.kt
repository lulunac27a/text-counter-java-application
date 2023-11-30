import java.awt.FlowLayout
import java.awt.Frame
import javax.swing.*

class textCounterKotlin {
    private var textContent: JTextArea
    private var updateText: JButton
    private var textCountResult: JLabel

    init {
        val textCount: Frame =
                JFrame("Text Counter Application") // initialize frame and set title of frame
        textCount.setLayout(FlowLayout())
        textCount.setSize(480, 320) // set application size to 480x320
        textContent = JTextArea(10, 80) // create text area with 10 rows and 80 columns
        textCount.add(textContent) // add components to the frame
        updateText = JButton("Calculate text count")
        textCount.add(updateText)
        textCountResult =
                JLabel("Characters: 0\nWords: 0\nLines: 0") // set the default text counter output
        textCount.add(textCountResult)
        textCount.isVisible = true // make the frame visible
        updateText.addActionListener {
            // when button is clicked
            val chars = textContent.getText().length // get length of text area in characters
            val words =
                    textContent
                            .getText()
                            .trim { it <= ' ' }
                            .split("\\s+".toRegex())
                            .dropLastWhile { it.isEmpty() }
                            .toTypedArray()
                            .size // get length of text area in words
            val lines =
                    textContent
                            .getText()
                            .split("\\r?\\n".toRegex())
                            .dropLastWhile { it.isEmpty() }
                            .toTypedArray()
                            .size // get length of text area in lines
            textCountResult.setText(
                    "Characters: $chars\nWords: $words\nLines: $lines"
            ) // update text counter output
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
