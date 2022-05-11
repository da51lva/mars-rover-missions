package matt.thewizard.techreturners.marsrovermissions.view;

import matt.thewizard.techreturners.marsrovermissions.model.Rover;

import java.io.Console;
import java.util.List;

import static matt.thewizard.techreturners.marsrovermissions.view.ViewComponents.*;

public class ConsoleView {


    private Console console;

    public ConsoleView(Console console) {
        this.console = console;
    }

    public void displayWelcome() {
        System.out.println(WELCOME_TOP_LINE_MESSAGE);
        System.out.println(MARS_ROVER_MESSAGE);
        System.out.println(MISSIONS_MESSAGE);
        System.out.println(WELCOME_BOTTOM_LINE_MESSAGE);
    }

    public String displayPlateauInput() {
        System.out.println("\nPlease enter a size for your plateau to start using the form 'X Y'\n");
        System.out.println("e.g. '10 5'\n");

        return console.readLine();
    }

    public String displayAddNewRover() {
        System.out.println("\nEnter a starting position and orientation for your new Rover :)\n");
        System.out.println("Use the format 'X Y Orientation' e.g. 5 5 N\n");
        return console.readLine();
    }

    public String displayMoveRover() {
        System.out.println("\nEnter a List of moves for the selected Rover\n");
        System.out.println(ViewComponents.INDENT + "M = Move");
        System.out.println(ViewComponents.INDENT + "L = Rotate Left");
        System.out.println(ViewComponents.INDENT + "R = Rotate Right\n");
        System.out.println("e.g. 'MMRMLMM' , 'RM' . 'MLLMMM' etc.\n");
        return console.readLine();
    }

    public String displayChooseOption() {
        System.out.println("\nPlease choose from the following options:\n");
        System.out.println("[1] - Add a new Rover\n");
        System.out.println("[2] - Move an existing Rover\n");

        return console.readLine();
    }

    public String displayChooseRover() {
        System.out.println("\nPlease select a rover to move by entering a number:\n");
        System.out.println("E.g. '1'\n");
        return console.readLine();
    }


    public void displayGrid(int xMax, int yMax, List<Rover> rovers) {

        String rowBorderNotCentral = //builds the separator between rows
                ViewComponents.GRID_COMPONENT_1.repeat(xMax + 1) + ViewComponents.GRID_COMPONENT_3 + System.lineSeparator();

        String TAB = " ".repeat(DISPLAY_WIDTH / 2 - rowBorderNotCentral.length() / 2); //Used to center the grid in the console

        String rowBorder = TAB + rowBorderNotCentral; //center the row Border

        String row = //a single row of the grid
                rowBorder + (
                                TAB //Centers the row
                                + ViewComponents.GRID_COMPONENT_2.repeat(xMax + 1)
                                + ViewComponents.GRID_COMPONENT_4
                                + System.lineSeparator()
                ).repeat(ViewComponents.BOX_HEIGHT);

        StringBuilder gridBuilder = //fully constructed grid
                new StringBuilder().append(row.repeat(yMax + 1)).append(rowBorder);

        //Replace characters in grid that represent rover positions and orientations
        rovers.stream()
                .forEach((r) -> replaceChars(r, gridBuilder, rowBorder, yMax, TAB.length()));

        System.out.println(gridBuilder);
    }

    public void displayGoodbye() {
        System.out.println("\nThanks for playing! Goodbye :-)");
    }

    /**
     * Replaces the characters in a grid which represent a given rover and its orientation
     *
     * @param rover
     * @param gridBuilder - the grid being built
     * @param rowBorder   - the separator between rows in the grid. Used to determine the number of characters per line
     * @param yMax        - the vertical size of the grid.
     */
    private void replaceChars(Rover rover, StringBuilder gridBuilder, String rowBorder, int yMax, int tabSize) {

        int charIndexOfRover = getCharIndexToReplace(rover, rowBorder, yMax, tabSize);

        //calculates index of orientation symbol
        String orientationSymbol = "";
        int orientationOffset = 0;
        switch (rover.getOrientation()) {
            case N -> {
                orientationSymbol = "^";
                orientationOffset = charIndexOfRover - rowBorder.length();
            }
            case S -> {
                orientationSymbol = "v";
                orientationOffset = charIndexOfRover + rowBorder.length();
            }
            case E -> {
                orientationSymbol = ">";
                orientationOffset = charIndexOfRover + 2;
            }
            case W -> {
                orientationSymbol = "<";
                orientationOffset = charIndexOfRover - 2;
            }
        }

        gridBuilder.replace(charIndexOfRover, charIndexOfRover + 1, String.valueOf(rover.getId()));
        gridBuilder.replace(orientationOffset, orientationOffset + 1, orientationSymbol);


    }

    /**
     * Calculates the char index that represent a given rover in the grid
     */
    private int getCharIndexToReplace(Rover rover, String rowBorder, int yMax, int tabSize) {
        int columns = rover.getPosition().getX();
        int rows = rover.getPosition().getY();
        int yFlipped = yMax - rows;

        int charsPerLine = rowBorder.length();
        int startingRow = charsPerLine * (BOX_HEIGHT + 1) / 2;
        int charsBetweenColumn = GRID_COMPONENT_1.length();
        int startingColumn = tabSize + GRID_COMPONENT_1.length() / 2 + 1;
        int linesPerRow = BOX_HEIGHT + 1;
        return (startingRow + (yFlipped * (charsPerLine * linesPerRow)) + startingColumn + (charsBetweenColumn * columns)) - 1;
    }

    public static void displayInputErrorMessage(String input) {
        System.err.println(String.format("'%s' is not a valid input: Please try again", input));
    }
}
