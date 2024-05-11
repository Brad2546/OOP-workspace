import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OverwriteWarningWindow extends JFrame implements ActionListener {

    public SaveWindow main;
    public JFrame frame;
    public String fileName, fileType;

    public OverwriteWarningWindow(SaveWindow main, String fileName, String fileType) {
        this.main = main;
        this.fileName = fileName;
        this.fileType = fileType;

        frame = new JFrame("Warning - file already exists");
        JPanel panel = new JPanel();

        JButton buttonSaveFile = new JButton("Overwrite file");
        buttonSaveFile.addActionListener(this);
        JButton buttonLoadFile = new JButton("Go back");
        buttonLoadFile.addActionListener(this);

        JLabel labelInfo = new JLabel("! Warning - current file already exists !");
        JLabel labelInfo2 = new JLabel("Saving this file will overwrite the existing one...");
        panel.add(labelInfo);
        panel.add(labelInfo2);
        panel.add(buttonSaveFile);
        panel.add(buttonLoadFile);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Overwrite file")) {
            main.saveFile(fileName, fileType);
        }
        frame.setVisible(false);
        frame.dispose();
    }
}