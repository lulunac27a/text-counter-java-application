import javax.swing.*
import javax.swing.filechooser.FileNameExtensionFilter
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class fileTextCounterGroovy {

    JButton selectFile = new JButton('Select file')
    JLabel textCountResult

    fileTextCounterGroovy() {
        Frame textCount = new JFrame('File Text Counter Application')// initialize frame and set title of frame
        textCount.layout = new FlowLayout()
        textCount.setSize(480, 400)// set application size to 480x400
        textCount.add(selectFile)// add components to the frame
        textCountResult = new JLabel('Characters: 0\nWords: 0\nLines: 0')// set the default text counter output
        textCount.add(textCountResult)
        textCount.visible = true// make the frame visible
        selectFile.addActionListener(new ActionListener() {

            @Override
            void actionPerformed(ActionEvent e) { // when the button is clicked
                JFileChooser fileChooser = new JFileChooser()// create a new file chooser
                fileChooser.fileFilter = new FileNameExtensionFilter('Text files', 'txt')
                int fileResult = fileChooser.showOpenDialog(textCount)// show file dialog
                final String textContent
                try {
                    textContent = getTextContent(fileResult, fileChooser)
                } catch (IOException ex) {
                    throw new RuntimeException(ex)
                }
                int chars = textContent.length()// get the length of text area in characters
                int words = textContent.trim().split('\\s+').length// get the length of text area in words
                int lines = textContent.split('\\r?\\n').length// get the length of text area in lines
                textCountResult.text = 'Characters: ' + String.format('%,d', chars) + '\nWords: ' + String.format('%,d', words) + '\nLines: ' + String.format('%,d', lines)// update text counter output
            }

            private static String getTextContent(int fileResult, JFileChooser fileChooser) throws IOException {
                String textContent = ''// initialize empty text content string
                if (fileResult == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.selectedFile.path// get the file path
                    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                        String line
                        while ((line = reader.readLine()) != null) {
                            textContent += line + '\n'// read text from a file every line
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
