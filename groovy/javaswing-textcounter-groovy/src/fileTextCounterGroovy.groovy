import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class fileTextCounterGroovy {
    JButton selectFile = new JButton("Select file")
    JLabel textCountResult

     fileTextCounterGroovy() {
        Frame textCount = new JFrame("File Text Counter Application")// initialize frame and set title of frame
        textCount.setLayout(new FlowLayout())
        textCount.setSize(480, 320)// set application size to 480x320
        textCount.add(selectFile)// add components to the frame
        textCountResult = new JLabel("Characters: 0\nWords: 0\nLines: 0")// set the default text counter output
        textCount.add(textCountResult)
        textCount.setVisible(true)// make the frame visible
        selectFile.addActionListener(new ActionListener() {
            @Override
             void actionPerformed(ActionEvent e) {// when button is clicked
                JFileChooser fileChooser = new JFileChooser()//create a new file chooser
                int fileResult = fileChooser.showOpenDialog(textCount)//show file dialog
                final String textContent
                try {
                    textContent = getTextContent(fileResult, fileChooser)
                } catch (IOException ex) {
                    throw new RuntimeException(ex)
                }
                int chars = textContent.length()// get length of text area in characters
                int words = textContent.trim().split("\\s+").length// get length of text area in words
                int lines = textContent.split("\\r?\\n").length// get length of text area in lines
                textCountResult.setText("Characters: " + chars + "\nWords: " + words + "\nLines: " + lines)// update text count output
            }

            private static String getTextContent(int fileResult, JFileChooser fileChooser) throws IOException {
                String textContent = ""//initialize empty text content string
                if (fileResult == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getPath()//get the file path
                    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                        String line
                        while ((line = reader.readLine()) != null) {
                            textContent += line + "\n"//read text from a file every line
                        }
                    }
                }
                return textContent
            }
        })
    }

     static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
             void run() {
                new fileTextCounterGroovy()// launch the application by running the program
            }
        })
    }
}
