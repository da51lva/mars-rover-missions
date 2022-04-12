package com.techreturners.marsroverkata.app;

import com.techreturners.marsroverkata.model.Orientation;

import java.util.Scanner;

public class ConsoleView {

    private Presenter presenter;

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

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

    public void displayResult(int x, int y, Orientation orientation) {
        System.out.println(String.format("%s %s %s", x, y, orientation));
    }
}
