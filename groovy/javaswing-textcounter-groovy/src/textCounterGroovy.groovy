import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class textCounterGroovy {
    JTextArea textContent;
    JButton updateText;
    JLabel textCountResult;

    public textCounterGroovy() {
        Frame textCount = new JFrame("Text Counter Application");
        textCount.setLayout(new FlowLayout());
        textCount.setSize(480, 320);// set application size to 480x320
        textContent = new JTextArea(10, 80);// create text area with 10 rows and 80 columns
        textCount.add(textContent);// add componments to the frame
        updateText = new JButton("Calculate text count");
        textCount.add(updateText);
        textCountResult = new JLabel("Characters: 0\nWords: 0\nLines: 0");// set the default text counter output
        textCount.add(textCountResult);
        textCount.setVisible(true);// make the frame visible
        updateText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {// when button is clicked
                int chars = textContent.getText().length();// get text area characters
                int words = textContent.getText().trim().split("\\s+").length;// get text area in words
                int lines = textContent.getText().split("\\r?\\n").length;// get text area in lines
                textCountResult.setText("Characters: " + chars + "\nWords: " + words + "\nLines: " + lines);// update
                                                                                                            // text
                                                                                                            // counter
                                                                                                            // output
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new textCounterGroovy();// run the text counter application
            }
        });
    }
}
