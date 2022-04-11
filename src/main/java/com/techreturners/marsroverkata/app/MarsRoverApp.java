package com.techreturners.marsroverkata.app;

public class MarsRoverApp {

    public static void main(String args[]){
        MarsRoverController marsRoverController = new MarsRoverController();
        ConsoleView consoleView = new ConsoleView();
        Presenter presenter = new Presenter(marsRoverController,consoleView);
        consoleView.setPresenter(presenter);
        consoleView.welcome();
    }
}
