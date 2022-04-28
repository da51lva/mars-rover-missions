package matt.thewizard.techreturners.marsrovermissions.view;

import matt.thewizard.techreturners.marsrovermissions.model.Rover;

import java.io.Console;
import java.util.List;

public class ConsoleView {

    //ascii text generator 'isometric2' font
    private static final String MARS_ROVER_MESSAGE = """
                  ___           ___           ___           ___                    ___           ___                         ___           ___    \s
                 /\\  \\         /\\  \\         /\\  \\         /\\__\\                  /\\  \\         /\\  \\          ___          /\\__\\         /\\  \\   \s
                |::\\  \\       /::\\  \\       /::\\  \\       /:/ _/_                /::\\  \\       /::\\  \\        /\\  \\        /:/ _/_       /::\\  \\  \s
                |:|:\\  \\     /:/\\:\\  \\     /:/\\:\\__\\     /:/ /\\  \\              /:/\\:\\__\\     /:/\\:\\  \\       \\:\\  \\      /:/ /\\__\\     /:/\\:\\__\\ \s
              __|:|\\:\\  \\   /:/ /::\\  \\   /:/ /:/  /    /:/ /::\\  \\            /:/ /:/  /    /:/  \\:\\  \\       \\:\\  \\    /:/ /:/ _/_   /:/ /:/  / \s
             /::::|_\\:\\__\\ /:/_/:/\\:\\__\\ /:/_/:/__/___ /:/_/:/\\:\\__\\          /:/_/:/__/___ /:/__/ \\:\\__\\  ___  \\:\\__\\  /:/_/:/ /\\__\\ /:/_/:/__/___
             \\:\\~~\\  \\/__/ \\:\\/:/  \\/__/ \\:\\/:::::/  / \\:\\/:/ /:/  /          \\:\\/:::::/  / \\:\\  \\ /:/  / /\\  \\ |:|  |  \\:\\/:/ /:/  / \\:\\/:::::/  /
              \\:\\  \\        \\::/__/       \\::/~~/~~~~   \\::/ /:/  /            \\::/~~/~~~~   \\:\\  /:/  /  \\:\\  \\|:|  |   \\::/_/:/  /   \\::/~~/~~~~\s
               \\:\\  \\        \\:\\  \\        \\:\\~~\\        \\/_/:/  /              \\:\\~~\\        \\:\\/:/  /    \\:\\__|:|__|    \\:\\/:/  /     \\:\\~~\\    \s
                \\:\\__\\        \\:\\__\\        \\:\\__\\         /:/  /                \\:\\__\\        \\::/  /      \\::::/__/      \\::/  /       \\:\\__\\   \s
                 \\/__/         \\/__/         \\/__/         \\/__/                  \\/__/         \\/__/        ~~~~           \\/__/         \\/__/   \s
                        
            """;

    private static final String MISSIONS_MESSAGE = """
                                           ___                       ___           ___                       ___           ___    \s
                                          /\\  \\                     /\\__\\         /\\__\\                     /\\  \\         /\\  \\   \s
                                         |::\\  \\       ___         /:/ _/_       /:/ _/_       ___         /::\\  \\        \\:\\  \\  \s
                                         |:|:\\  \\     /\\__\\       /:/ /\\  \\     /:/ /\\  \\     /\\__\\       /:/\\:\\  \\        \\:\\  \\ \s
                                       __|:|\\:\\  \\   /:/__/      /:/ /::\\  \\   /:/ /::\\  \\   /:/__/      /:/  \\:\\  \\   _____\\:\\  \\\s
                                      /::::|_\\:\\__\\ /::\\  \\     /:/_/:/\\:\\__\\ /:/_/:/\\:\\__\\ /::\\  \\     /:/__/ \\:\\__\\ /::::::::\\__\\
                                      \\:\\~~\\  \\/__/ \\/\\:\\  \\__  \\:\\/:/ /:/  / \\:\\/:/ /:/  / \\/\\:\\  \\__  \\:\\  \\ /:/  / \\:\\~~\\~~\\/__/
                                       \\:\\  \\        ~~\\:\\/\\__\\  \\::/ /:/  /   \\::/ /:/  /   ~~\\:\\/\\__\\  \\:\\  /:/  /   \\:\\  \\     \s
                                        \\:\\  \\          \\::/  /   \\/_/:/  /     \\/_/:/  /       \\::/  /   \\:\\/:/  /     \\:\\  \\    \s
                                         \\:\\__\\         /:/  /      /:/  /        /:/  /        /:/  /     \\::/  /       \\:\\__\\   \s
                                          \\/__/         \\/__/       \\/__/         \\/__/         \\/__/       \\/__/         \\/__/   \s
            
            """;

    private static final String s = "+---";
    private static final String s1 = "|   ";
    private static final String s2 = "+";
    private static final String s3 = "|";

    private Console console;

    public ConsoleView(Console console) {
        this.console = console;
    }

    public void displayWelcome(){
        System.out.println("----------------------------------------------------------   Welcome to the   ----------------------------------------------------------");
        System.out.println(MARS_ROVER_MESSAGE);
        System.out.println(MISSIONS_MESSAGE);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
    }

    public String displayPlateauInput() {
        System.out.println("Please enter a size for your plateau to start using the form 'X Y'");
        System.out.println("e.g. '10 5'");

        return console.readLine();
    }

    public String displayAddNewRover() {
        System.out.println("Enter a starting position and orientation for your new Rover :)");
        System.out.println("Use the format 'X Y Orientation' e.g. 5 5 N");
        return console.readLine();
    }

    public String displayMoveRover() {
        System.out.println("Enter a List of moves for the selected Rover");
        System.out.println("M = Move");
        System.out.println("L = Rotate Left");
        System.out.println("R = Rotate Right");
        System.out.println("e.g. 'MMRMLMM' , 'RM' . 'MLLMMM' etc.");
        return console.readLine();
    }

    public String displayChooseOption() {
        System.out.println("Please choose from the following options:\n");
        System.out.println("[1] - Add a new Rover\n");
        System.out.println("[2] - Move an existing Rover\n");

        return console.readLine();
    }

    public String displayChooseRover() {
        System.out.println("Please select a rover to move by entering a number:\n");
        System.out.println("E.g. '1'");
        return console.readLine();
    }

    public void displayGrid(int xMax, int yMax, List<Rover> rovers) {

        String rowBorder = s.repeat(xMax + 1) + s2 + System.lineSeparator();
        String row = rowBorder + s1.repeat(xMax + 1) + s3 + System.lineSeparator();
        StringBuilder gridBuilder = new StringBuilder().append(row.repeat(yMax + 1)).append(rowBorder);

        for (Rover rover : rovers) {
            int columns = rover.getPosition().getX();
            int rows = rover.getPosition().getY();
            int yFlipped = yMax - rows;

            int charsPerLine = 2 + 4 * (xMax + 1);
            int startingRow = charsPerLine;
            int charsBetweenColumn = 4;
            int startingColumn = 3;
            int linesPerRow = 2;
            int charIndex = startingRow + (yFlipped * (charsPerLine * linesPerRow)) + startingColumn + (charsBetweenColumn * columns);

            gridBuilder.replace(charIndex - 1, charIndex, String.valueOf(rover.getId()));
        }

        System.out.println(gridBuilder);
    }

    public void displayGoodbye() {
        System.out.println("Thanks for playing! Goodbye :-)");
    }
}
