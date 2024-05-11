import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SaveWindow extends JFrame implements ActionListener {

    public JTextArea textArea;
    public TurtleGraphics main;
    public JFrame frame;

    public SaveWindow(TurtleGraphics main) {
        this.main = main;

        frame = new JFrame("File save menu");
        JPanel panel = new JPanel();

        JButton buttonSaveJpeg = new JButton("Save as .jpeg");
        buttonSaveJpeg.addActionListener(this);
        JButton buttonSaveTxt = new JButton("Save as .txt");
        buttonSaveTxt.addActionListener(this);
        JButton buttonCancel = new JButton("Cancel");
        buttonCancel.addActionListener(this);

        JLabel labelInfo = new JLabel("Enter desired filename");
        textArea = new JTextArea(1, 10);

        panel.add(labelInfo);
        panel.add(textArea);
        panel.add(buttonSaveJpeg);
        panel.add(buttonSaveTxt);
        panel.add(buttonCancel);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Save as .jpeg")) {
            String fileName = textArea.getText() + ".jpg";
            if (Files.exists(Path.of(fileName))) {
                new OverwriteWarningWindow(this, fileName, "jpeg");
            } else {
                saveFile(fileName, "jpeg");
            }

        } else if (command.equals("Save as .txt")) {
            String fileName = textArea.getText() + ".txt";
            if (Files.exists(Path.of(fileName))) {
                new OverwriteWarningWindow(this, fileName, "txt");
            } else {
                saveFile(fileName, "txt");
            }

        } else {
            closeWindow();
        }
    }

    public void saveFile(String fileName, String fileType) {
        if (fileType.equals("jpeg")) {
            try {
                BufferedImage currentImage = main.getBufferedImage();
                File saveFile = new File(fileName);
                ImageIO.write(currentImage, "JPEG", saveFile);
                main.displayMessage("Image saved");
                main.setSavedStatus();
            } catch (IOException exception) {
                main.displayMessage("ERROR - could not save image file");
            }

        } else if (fileType.equals("txt")) {
            try {
                ArrayList<String> usedCommands = main.getUsedCommands();
                FileWriter saveFile = new FileWriter(fileName);
                for (String eachUsedCommand : usedCommands) {
                    saveFile.write(eachUsedCommand + "\n");
                }
                saveFile.close();
                main.displayMessage("Text file saved");
                main.setSavedStatus();
            } catch (IOException exception) {
                main.displayMessage("ERROR - could not save text file");
            }

        } else {
            main.displayMessage("ERROR - invalid save file format");
        }
        closeWindow();
    }

    public void closeWindow() {
        frame.setVisible(false);
        frame.dispose();
    }
}
