import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class textCounterGroovy {

    JTextArea textContent
    JButton updateText
    JLabel textCountResult

    textCounterGroovy() {
        Frame textCount = new JFrame('Text Counter Application')// initialize frame and set title of frame
        textCount.layout = new FlowLayout()
        textCount.setSize(480, 320)// set application size to 480x320
        textContent = new JTextArea(10, 40)// create text area with 10 rows and 40 columns
        textCount.add(textContent)// add components to the frame
        updateText = new JButton('Calculate text count')
        textCount.add(updateText)
        textCountResult = new JLabel('Characters: 0\nWords: 0\nLines: 0')// set the default text counter output
        textCount.add(textCountResult)
        textCount.visible = true// make the frame visible
        updateText.addActionListener(new ActionListener() {

            @Override
            void actionPerformed(ActionEvent e) { // when the button is clicked
                int chars = textContent.text.length// get the length of text area in characters
                int words = textContent.text.trim().split('\\s+').length// get the length of text area in words
                int lines = textContent.text.split('\\r?\\n').length// get the length of text area in lines
                textCountResult.text = 'Characters: ' + String.format('%,d', chars) + '\nWords: '
                + String.format('%,d', words) + '\nLines: ' + String.format('%,d', lines)// update text
                                                                                         // counter output
            }

        })
    }

    static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            void run() {
                new textCounterGroovy()// launch the application by running the program
            }

        })
    }

}
