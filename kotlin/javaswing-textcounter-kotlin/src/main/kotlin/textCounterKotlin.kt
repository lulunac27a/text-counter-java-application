import java.awt.FlowLayout
import java.awt.Frame
import javax.swing.*

class textCounter {
    var textContent: JTextArea
    var updateText: JButton
    var textCountResult: JLabel

    init {
        val textCount: Frame = JFrame("Text Counter Application")
        textCount.setLayout(FlowLayout())
        textCount.setSize(480, 320)
        textContent = JTextArea(10, 80)
        textCount.add(textContent)
        updateText = JButton("Calculate text count")
        textCount.add(updateText)
        textCountResult = JLabel("Characters: 0\nWords: 0\nLines: 0")
        textCount.add(textCountResult)
        textCount.isVisible = true
        updateText.addActionListener {
            val chars = textContent.getText().length
            val words = textContent.getText().trim { it <= ' ' }.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray().size
            val lines =
                textContent.getText().split("\\r?\\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().size
            textCountResult.setText("Characters: $chars\nWords: $words\nLines: $lines")
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SwingUtilities.invokeLater { textCounter() }
        }
    }
}
