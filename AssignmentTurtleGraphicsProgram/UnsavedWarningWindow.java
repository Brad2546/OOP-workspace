import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnsavedWarningWindow extends JFrame implements ActionListener {

    public TurtleGraphics main;
    public JFrame frame;
    public String warningType;

    public UnsavedWarningWindow(TurtleGraphics main, String warningType) {
        this.main = main;
        this.warningType = warningType;

        frame = new JFrame("Warning - unsaved image");
        JPanel panel = new JPanel();

        JButton buttonSaveFile = new JButton("Save current image");
        buttonSaveFile.addActionListener(this);
        JButton buttonLoadFile = new JButton("Continue anyway...");
        buttonLoadFile.addActionListener(this);

        JLabel labelInfo = new JLabel("! Warning - current image file is unsaved !");
        JLabel labelInfo2 = new JLabel("any unsaved data will be lost...");
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

        if (command.equals("Save current image")) {
            main.save();
        } else {
            if (warningType.equals("load")) {
                main.load();
            } else {
                main.clear();
            }
        }
        frame.setVisible(false);
        frame.dispose();
    }
}
