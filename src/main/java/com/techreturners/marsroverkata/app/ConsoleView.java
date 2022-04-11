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
            acceptPlateauInput(scanner);

            System.out.println("And now a Rover's start position and orientation");
            acceptRoverInput(scanner);

            System.out.println("And now a list of moves for your Rover");
            acceptMovesInput(scanner);
        }

    }

    private void acceptPlateauInput(Scanner scanner) {
        String input = scanner.nextLine();
        presenter.executePlateauSizeInput(input);
    }


    private void acceptRoverInput(Scanner scanner) {
        String input = scanner.nextLine();
        presenter.executeNewRoverInput(input);
    }

    private void acceptMovesInput(Scanner scanner) {
        String input = scanner.nextLine();
        presenter.executeMovesInput(input);
    }


    public void displayResult(int x, int y, Orientation orientation) {
        System.out.println(String.format("%s %s %s", x, y, orientation));
    }
}
