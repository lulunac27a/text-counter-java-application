import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class textCounter {

  JTextArea textContent;
  JButton updateText;
  JLabel textCountResult;

  public textCounter() {
    Frame textCount = new JFrame("Text Counter Application"); // initialize frame and set title of frame
    textCount.setLayout(new FlowLayout());
    textCount.setSize(480, 400); // set application size to 480x400
    textContent = new JTextArea(10, 40); // create text area with 10 rows and 40 columns
    textCount.add(textContent); // add components to the frame
    updateText = new JButton("Calculate text count");
    textCount.add(updateText);
    textCountResult = new JLabel("Characters: 0\nWords: 0\nLines: 0"); // set the default text counter output
    textCount.add(textCountResult);
    textCount.setVisible(true); // make the frame visible
    updateText.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) { // when the button is clicked
            int chars = textContent.getText().length(); // get the length of text area in characters
            int words = textContent.getText().trim().split("\\s+").length; // get the length of text area in words
            int lines = textContent.getText().split("\\r?\\n").length; // get the length of text area in lines
            textCountResult.setText(
                "Characters: " +
                    String.format("%,d", chars) +
                    "\nWords: " +
                    String.format("%,d", words) +
                    "\nLines: " +
                    String.format("%,d", lines)); // update text counter output
          }
        });
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            new textCounter(); // launch the application by running the program
          }
        });
  }
}
