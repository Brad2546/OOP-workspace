import uk.ac.leedsbeckett.oop.OOPGraphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

interface SingleRunnable {
    void run(String p1);
}

interface TripleRunnable {
    void run(String p1, String p2, String p3);
}

public class TurtleGraphics extends OOPGraphics {

    // hashmap contains all command shortcuts for O(1) fetch time
    private HashMap<String, Runnable> noParameterCommands;
    private HashMap<String, SingleRunnable> singleParameterCommands;
    private HashMap<String, TripleRunnable> tripleParameterCommands;
    private ArrayList<String> usedCommands;
    private boolean saveStatus;

    public TurtleGraphics() {
        JFrame MainFrame = new JFrame();                //create a frame to display the turtle panel on
        MainFrame.setLayout(new FlowLayout());  //not strictly necessary
        MainFrame.add(this);                                    //"this" is this object that extends turtle graphics so we are adding a turtle graphics panel to the frame
        MainFrame.pack();                                               //set the frame to a size we can see
        MainFrame.setVisible(true);                             //now display it
        setupCommands();

        usedCommands = new ArrayList<>();
        saveStatus = true;

        about();
    }

    private void setupCommands () {
        noParameterCommands = new HashMap<>();
        noParameterCommands.put("about", this::about);
        noParameterCommands.put("clear", this::validateClear);
        noParameterCommands.put("reset", this::reset);
        noParameterCommands.put("penup", this::penUp);
        noParameterCommands.put("pendown", this::penDown);
        noParameterCommands.put("red", () -> setPenColour(Color.red));
        noParameterCommands.put("green", () -> setPenColour(Color.green));
        noParameterCommands.put("blue", () -> setPenColour(Color.blue));
        noParameterCommands.put("yellow", () -> setPenColour(Color.yellow));
        noParameterCommands.put("white", () -> setPenColour(Color.white));
        noParameterCommands.put("black", () -> setPenColour(Color.black));
        noParameterCommands.put("save", this::save);
        noParameterCommands.put("load", this::validateLoad);

        singleParameterCommands = new HashMap<>();
        singleParameterCommands.put("forward", this::forward);
        singleParameterCommands.put("backward", (p1) -> forward("-"+p1));
        singleParameterCommands.put("turnleft", this::turnLeft);
        singleParameterCommands.put("turnright", this::turnRight);
        singleParameterCommands.put("square", this::drawSquare);
        singleParameterCommands.put("penwidth", (p1) -> setStroke(Integer.parseInt(p1)));
        singleParameterCommands.put("triangle", this::drawEquilateralTriangle);

        tripleParameterCommands = new HashMap<>();
        tripleParameterCommands.put("pencolour", (r,g,b) ->
                setPenColour(new Color(Integer.parseInt(r), Integer.parseInt(g), Integer.parseInt(b))));

        tripleParameterCommands.put("triangle", (side1, side2, side3) ->
                drawSpecifiedTriangle(Integer.parseInt(side1), Integer.parseInt(side2), Integer.parseInt(side3)));
    }

    public void processCommand(String command) {
        displayMessage("OOPGraphics V5.1");
        String[] commandList = command.split(" ");
        int parameterCount = commandList.length -1;
        String commandType = commandList[0].toLowerCase();

        switch (parameterCount) {
            case 0:
                try {
                    noParameterCommands.get(commandType).run();
                    addUsedCommand(command);
                } catch (NullPointerException exception) {
                    validateCommand(commandType);
                }
                break;

            case 1:
                try {
                    if (validateParameters(new String[]{commandList[1]}, commandType)) {
                        singleParameterCommands.get(commandType).run(commandList[1]);
                        addUsedCommand(command);
                    }
                } catch (NullPointerException exception) {
                    validateCommand(commandType);
                }
                break;

            case 3:
                try {
                    if (validateParameters(new String[]{commandList[1],commandList[2],commandList[3]}, commandType)) {
                        tripleParameterCommands.get(commandType).run(commandList[1], commandList[2], commandList[3]);
                        addUsedCommand(command);
                    }
                } catch (NullPointerException exception) {
                    validateCommand(commandType);
                }
                break;

            default:
                validateCommand(commandType);
        }
    }

    private boolean validateParameters(String[] testParameters, String commandType) {
        for (String eachTestParameter : testParameters) {
            try {
                int testInteger = Integer.parseInt(eachTestParameter);
                if (testInteger >= 0 && testInteger <= 300) {
                    return true;
                } else {
                    displayMessage("ERROR - parameter out of bounds");
                    return false;
                }
            } catch (Exception exception) {
                if (Arrays.asList("save", "load").contains(commandType)) {
                    return true;
                }
                displayMessage("ERROR - non numerical parameter");
                return false;
            }
        }
        return false;
    }

    private void validateCommand(String testCommand) {
        if (noParameterCommands.containsKey(testCommand)) {
            displayMessage("ERROR - command \""+testCommand+"\" requires no parameters");
        } else if (singleParameterCommands.containsKey(testCommand)) {
            displayMessage("ERROR - command \""+testCommand+"\" requires 1 parameter");
        } else if (tripleParameterCommands.containsKey(testCommand)) {
            displayMessage("ERROR - command \""+testCommand+"\" requires 3 parameters");
        } else {
            displayMessage("ERROR - invalid command \""+testCommand+"\"");
        }
    }

    private void drawSquare(String length) {
        for (int i=0; i<4; i++) {
            forward(length);
            turnLeft(90);
        }
    }

    private void drawEquilateralTriangle(String length) {
        turnLeft(30);
        for (int i=0; i<3; i++) {
            turnLeft(60);
            forward(length);
            turnLeft(60);
        }
        turnRight(30);
    }

    private void drawSpecifiedTriangle(int a, int b, int c) {
        int A = getSpecifiedTriangleInteriorAngle(a, b ,c);
        int B = getSpecifiedTriangleInteriorAngle(b, a, c);
        int C = getSpecifiedTriangleInteriorAngle(c, a, b);

        if (A != 0 && B != 0 && C != 0) {
            forward(c);
            turnLeft(180 - B);
            forward(a);
            turnLeft(180 - C);
            forward(b);
            turnLeft(180 - A);
        } else {
            displayMessage("ERROR - impossible triangle");
        }
    }

    private int getSpecifiedTriangleInteriorAngle(int a, int b, int c) {
        return (int) Math.round(Math.toDegrees(Math.acos((double) (b * b + c * c - a * a) / (2*b*c))));
    }

    public void save() {
        new SaveWindow(this);
    }

    public void setSavedStatus() {
        saveStatus = true;
    }

    public boolean getSavedStatus() {
        return saveStatus;
    }

    private void addUsedCommand(String command) {
        if (! (command.contains("save") || command.contains("load") || command.contains("clear"))) {
            usedCommands.add(command);
            saveStatus = false;
        }
    }

    public ArrayList<String> getUsedCommands() {
        return usedCommands;
    }

    private void validateLoad() {
        if (! getSavedStatus()) {
            new UnsavedWarningWindow(this, "load");
        } else {
            load();
        }
    }

    public void load() {
        new LoadWindow(this);
    }

    public void reset() {
        super.reset();
        setStroke(1);
        setPenColour(Color.red);
    }

    public void clear() {
        super.clear();
        setSavedStatus();
        usedCommands = new ArrayList<>();
    }

    private void validateClear() {
        if (! getSavedStatus()) {
            new UnsavedWarningWindow(this, "clear");
        } else {
            clear();
        }
    }

    public void about() {
        clear();
        reset();
        super.about();
        Graphics g = this.getGraphics();
        g.setColor(Color.gray);
        g.drawString("Made by - Bradley Leach", 225, 215);
        g.setColor(Color.white);
        g.drawString("Made by - Bradley Leach", 228, 218);
    }
}
