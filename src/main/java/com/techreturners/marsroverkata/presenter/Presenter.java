package com.techreturners.marsroverkata.presenter;

import com.techreturners.marsroverkata.model.MarsRoverModel;
import com.techreturners.marsroverkata.model.Move;
import com.techreturners.marsroverkata.model.Orientation;
import com.techreturners.marsroverkata.view.ConsoleView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Presenter {

    private MarsRoverModel marsRoverModel;
    private ConsoleView consoleView;

    public Presenter(MarsRoverModel marsRoverModel, ConsoleView consoleView) {
        this.marsRoverModel = marsRoverModel;
        this.consoleView = consoleView;
    }

    public void executePlateauSizeInput(String input) {
        String[] split = input.split(" ");
        int xMAx = Integer.valueOf(split[0]);
        int yMax = Integer.valueOf(split[1]);
        marsRoverModel.createPlateau(xMAx, yMax);
    }

    public void executeNewRoverInput(String input){
        String[] split = input.split(" ");
        int x = Integer.valueOf(split[0]);
        int y = Integer.valueOf(split[1]);
        Orientation orientation = Orientation.valueOf(split[2]);
        marsRoverModel.addRover(x, y, orientation);
    }

    public void executeMovesInput(String input){
          List<Move> moves = Arrays.stream(input.split("")).map(Move::valueOf).collect(Collectors.toList());
          marsRoverModel.moveCurrentRover(moves);
          consoleView.displayResult(marsRoverModel.getCurrentRoverPosition().getX(),
                                    marsRoverModel.getCurrentRoverPosition().getY(),
                                    marsRoverModel.getCurrentRoverOrientation());
    }

}
