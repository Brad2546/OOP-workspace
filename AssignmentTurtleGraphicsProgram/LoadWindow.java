import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoadWindow extends JFrame implements ActionListener {

    public JTextArea textArea;
    public TurtleGraphics main;
    public JFrame frame;

    public LoadWindow(TurtleGraphics main) {
        this.main = main;

        frame = new JFrame("Load file menu");
        JPanel panel = new JPanel();

        JButton buttonLoadJpeg = new JButton("Load .jpeg");
        buttonLoadJpeg.addActionListener(this);
        JButton buttonLoadTxt = new JButton("Load .txt");
        buttonLoadTxt.addActionListener(this);
        JButton buttonCancel = new JButton("Cancel");
        buttonCancel.addActionListener(this);

        JLabel labelInfo = new JLabel("Enter desired filename");
        textArea = new JTextArea(1, 10);

        panel.add(labelInfo);
        panel.add(textArea);
        panel.add(buttonLoadJpeg);
        panel.add(buttonLoadTxt);
        panel.add(buttonCancel);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Load .jpeg")) {
            String fileName = textArea.getText() + ".jpg";
            try {
                BufferedImage image = ImageIO.read(new File(fileName));
                main.reset();
                main.clear();
                main.setBufferedImage(image);
                main.displayMessage("Image Loaded");
                main.setSavedStatus();
            } catch (IOException exception) {
                main.displayMessage("ERROR - could not load image");
            }
            closeWindow();

        } else if (command.equals("Load .txt")) {
            String fileName = textArea.getText() + ".txt";
            try {
                Scanner loadFile = new Scanner(new File(fileName));
                main.clear();
                main.reset();
                while (loadFile.hasNextLine()) {
                    String nextCommand = loadFile.nextLine();
                    System.out.println("Loaded command - "+nextCommand);
                    main.processCommand(nextCommand);
                }
                loadFile.close();
                main.displayMessage("Text file loaded");
                main.setSavedStatus();
            } catch (IOException exception) {
                main.displayMessage("ERROR - could not load text file");
            }
            closeWindow();

        } else {
            closeWindow();
        }
    }

    public void closeWindow() {
        frame.setVisible(false);
        frame.dispose();
    }
}
