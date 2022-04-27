package matt.thewizard.techreturners.marsrovermissions.view;

import matt.thewizard.techreturners.marsrovermissions.model.Orientation;
import matt.thewizard.techreturners.marsrovermissions.model.Rover;
import matt.thewizard.techreturners.marsrovermissions.presenter.Presenter;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    //ascii text generator 'isometric2' font
    private static final String WELCOME_MESSAGE = "Welcome to" +
            "      ___           ___           ___           ___                    ___           ___                         ___           ___     \n" +
            "     /\\  \\         /\\  \\         /\\  \\         /\\__\\                  /\\  \\         /\\  \\          ___          /\\__\\         /\\  \\    \n" +
            "    |::\\  \\       /::\\  \\       /::\\  \\       /:/ _/_                /::\\  \\       /::\\  \\        /\\  \\        /:/ _/_       /::\\  \\   \n" +
            "    |:|:\\  \\     /:/\\:\\  \\     /:/\\:\\__\\     /:/ /\\  \\              /:/\\:\\__\\     /:/\\:\\  \\       \\:\\  \\      /:/ /\\__\\     /:/\\:\\__\\  \n" +
            "  __|:|\\:\\  \\   /:/ /::\\  \\   /:/ /:/  /    /:/ /::\\  \\            /:/ /:/  /    /:/  \\:\\  \\       \\:\\  \\    /:/ /:/ _/_   /:/ /:/  /  \n" +
            " /::::|_\\:\\__\\ /:/_/:/\\:\\__\\ /:/_/:/__/___ /:/_/:/\\:\\__\\          /:/_/:/__/___ /:/__/ \\:\\__\\  ___  \\:\\__\\  /:/_/:/ /\\__\\ /:/_/:/__/___\n" +
            " \\:\\~~\\  \\/__/ \\:\\/:/  \\/__/ \\:\\/:::::/  / \\:\\/:/ /:/  /          \\:\\/:::::/  / \\:\\  \\ /:/  / /\\  \\ |:|  |  \\:\\/:/ /:/  / \\:\\/:::::/  /\n" +
            "  \\:\\  \\        \\::/__/       \\::/~~/~~~~   \\::/ /:/  /            \\::/~~/~~~~   \\:\\  /:/  /  \\:\\  \\|:|  |   \\::/_/:/  /   \\::/~~/~~~~ \n" +
            "   \\:\\  \\        \\:\\  \\        \\:\\~~\\        \\/_/:/  /              \\:\\~~\\        \\:\\/:/  /    \\:\\__|:|__|    \\:\\/:/  /     \\:\\~~\\     \n" +
            "    \\:\\__\\        \\:\\__\\        \\:\\__\\         /:/  /                \\:\\__\\        \\::/  /      \\::::/__/      \\::/  /       \\:\\__\\    \n" +
            "     \\/__/         \\/__/         \\/__/         \\/__/                  \\/__/         \\/__/        ~~~~           \\/__/         \\/__/" +
            "" +
            "      ___                       ___           ___                       ___           ___     \n" +
            "     /\\  \\                     /\\__\\         /\\__\\                     /\\  \\         /\\  \\    \n" +
            "    |::\\  \\       ___         /:/ _/_       /:/ _/_       ___         /::\\  \\        \\:\\  \\   \n" +
            "    |:|:\\  \\     /\\__\\       /:/ /\\  \\     /:/ /\\  \\     /\\__\\       /:/\\:\\  \\        \\:\\  \\  \n" +
            "  __|:|\\:\\  \\   /:/__/      /:/ /::\\  \\   /:/ /::\\  \\   /:/__/      /:/  \\:\\  \\   _____\\:\\  \\ \n" +
            " /::::|_\\:\\__\\ /::\\  \\     /:/_/:/\\:\\__\\ /:/_/:/\\:\\__\\ /::\\  \\     /:/__/ \\:\\__\\ /::::::::\\__\\\n" +
            " \\:\\~~\\  \\/__/ \\/\\:\\  \\__  \\:\\/:/ /:/  / \\:\\/:/ /:/  / \\/\\:\\  \\__  \\:\\  \\ /:/  / \\:\\~~\\~~\\/__/\n" +
            "  \\:\\  \\        ~~\\:\\/\\__\\  \\::/ /:/  /   \\::/ /:/  /   ~~\\:\\/\\__\\  \\:\\  /:/  /   \\:\\  \\      \n" +
            "   \\:\\  \\          \\::/  /   \\/_/:/  /     \\/_/:/  /       \\::/  /   \\:\\/:/  /     \\:\\  \\     \n" +
            "    \\:\\__\\         /:/  /      /:/  /        /:/  /        /:/  /     \\::/  /       \\:\\__\\    \n" +
            "     \\/__/         \\/__/       \\/__/         \\/__/         \\/__/       \\/__/         \\/__/  ";

    private static final String s = "+---";
    private static final String s1 = "|   ";
    private static final String s2 = "+";
    private static final String s3 = "|";
    private Presenter presenter;

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void welcome() {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println(WELCOME_MESSAGE);
            System.out.println("Please enter a size for your plateau to start");
            String input = scanner.nextLine();
            presenter.executePlateauSizeInput(input);

            while (true) {

                System.out.println("And now a Rover's start position and orientation");
                input = scanner.nextLine();
                if (input.equals("q")) break;
                else presenter.executeNewRoverInput(input);

                System.out.println("And now a list of moves for your Rover");
                input = scanner.nextLine();
                if (input.equals("q")) break;
                else presenter.executeMovesInput(input);
            }
        }

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

            gridBuilder.replace(charIndex - 1, charIndex, "X");
        }

        System.out.println(gridBuilder);
    }

    public void displayResult(int x, int y, Orientation orientation) {
        System.out.println(String.format("%s %s %s", x, y, orientation));
    }
}
