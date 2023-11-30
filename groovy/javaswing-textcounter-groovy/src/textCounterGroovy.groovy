import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

 class textCounterGroovy {
    JTextArea textContent
    JButton updateText
    JLabel textCountResult

     textCounterGroovy() {
        Frame textCount = new JFrame("Text Counter Application")// initialize frame and set title of frame
        textCount.setLayout(new FlowLayout())
        textCount.setSize(480, 320)// set application size to 480x320
        textContent = new JTextArea(10, 80)// create text area with 10 rows and 80 columns
        textCount.add(textContent)// add components to the frame
        updateText = new JButton("Calculate text count")
        textCount.add(updateText)
        textCountResult = new JLabel("Characters: 0\nWords: 0\nLines: 0")// set the default text counter output
        textCount.add(textCountResult)
        textCount.setVisible(true)// make the frame visible
        updateText.addActionListener(new ActionListener() {
            @Override
             void actionPerformed(ActionEvent e) {// when button is clicked
                int chars = textContent.getText().length()// get length of text area in characters
                int words = textContent.getText().trim().split("\\s+").length// get length of text area in words
                int lines = textContent.getText().split("\\r?\\n").length// get length of text area in lines
                textCountResult.setText("Characters: " + chars + "\nWords: " + words + "\nLines: " + lines)// update text count output
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
