package com.techreturners.marsroverkata.app;

import com.techreturners.marsroverkata.model.Move;
import com.techreturners.marsroverkata.model.Orientation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Presenter {

    private MarsRoverController marsRoverController;
    private ConsoleView consoleView;

    public Presenter(MarsRoverController marsRoverController, ConsoleView consoleView) {
        this.marsRoverController = marsRoverController;
        this.consoleView = consoleView;
    }

    public void executePlateauSizeInput(String input) {
        String[] split = input.split(" ");
        int xMAx = Integer.valueOf(split[0]);
        int yMax = Integer.valueOf(split[1]);
        marsRoverController.createPlateau(xMAx,yMax);
    }

    public void executeNewRoverInput(String input){
        String[] split = input.split(" ");
        int x = Integer.valueOf(split[0]);
        int y = Integer.valueOf(split[1]);
        Orientation orientation = Orientation.valueOf(split[2]);
        marsRoverController.addRover(x,y,orientation);
    }

    public void executeMovesInput(String input){
          List<Move> moves = Arrays.stream(input.split("")).map(Move::valueOf).collect(Collectors.toList());
          marsRoverController.moveCurrentRover(moves);
          consoleView.displayResult(marsRoverController.getCurrentRoverPosition().getX(),marsRoverController.getCurrentRoverPosition().getY(),marsRoverController.getCurrentRoverOrientation());
    }

}
