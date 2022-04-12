package com.techreturners.marsroverkata.view;

import com.techreturners.marsroverkata.model.Position;
import com.techreturners.marsroverkata.model.Rover;
import com.techreturners.marsroverkata.presenter.Presenter;
import com.techreturners.marsroverkata.model.Orientation;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {

    private Presenter presenter;

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private static final String s = "+---";
    private static final String s1 = "|   ";
    private static final String s2 = "+";
    private static final String s3 = "|";

    public void welcome() {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Welcome to the Mars Rover Mission");
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
    
    public void displayGrid(int xMin, int yMin, int xMax, int yMax, Map<Rover,Position> roverPositions){

        String rowBorder = s.repeat(xMax+1) + s2 + System.lineSeparator();
        String row = rowBorder + s1.repeat(xMax+1) + s3 + System.lineSeparator();
        StringBuilder gridBuilder = new StringBuilder().append(row.repeat(yMax + 1)).append(rowBorder);

        for(Map.Entry<Rover,Position> entry : roverPositions.entrySet()){
            int columns = entry.getValue().getX();
            int rows = entry.getValue().getY();
            int yFlipped = yMax - rows;

            int charsPerLine = 2 + 4 * (xMax+1);
            int startingRow = charsPerLine;
            int charsBetweenColumn = 4;
            int startingColumn = 3;
            int linesPerRow = 2;
            int charIndex = startingRow + (yFlipped * (charsPerLine * linesPerRow)) + startingColumn + (charsBetweenColumn * columns);

            gridBuilder.replace(charIndex-1, charIndex , "X");
        }

        System.out.println(gridBuilder);
    }

    public void displayResult(int x, int y, Orientation orientation) {
        System.out.println(String.format("%s %s %s", x, y, orientation));
    }
}
