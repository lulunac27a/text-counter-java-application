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
        textCount.setSize(480, 320);
        textContent = new JTextArea(10, 80);
        textCount.add(textContent);
        updateText = new JButton("Calculate text count");
        textCount.add(updateText);
        textCountResult = new JLabel("Characters: 0\nWords: 0\nLines: 0");
        textCount.add(textCountResult);
        textCount.setVisible(true);
        updateText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int chars = textContent.getText().length();
                int words = textContent.getText().trim().split("\\s+").length;
                int lines = textContent.getText().split("\\r?\\n").length;
                textCountResult.setText("Characters: " + chars + "\nWords: " + words + "\nLines: " + lines);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new textCounterGroovy();
            }
        });
    }
}
