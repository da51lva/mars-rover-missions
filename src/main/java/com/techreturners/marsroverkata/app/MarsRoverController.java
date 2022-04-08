package com.techreturners.marsroverkata.app;

import com.techreturners.marsroverkata.model.Move;
import com.techreturners.marsroverkata.model.Orientation;
import com.techreturners.marsroverkata.model.Plateau;
import com.techreturners.marsroverkata.model.Rover;

import java.awt.*;
import java.util.List;

public class MarsRoverController {

    private Rover currentRover;

    public void addRover(Rover rover) {
        currentRover = rover;
    }

    public Rover getCurrentRover() {
        return currentRover;
    }

    public void moveCurrentRover(List<Move> moves) {
        moves.stream().forEach(this::moveCurrentRover);
    }

    private void moveCurrentRover(Move move){
        switch (move){
            case M:
                currentRover.move();
                break;
            case R:
                currentRover.orientateRight();
                break;
            case L:
                currentRover.orientateLeft();
                break;
        }
    }
}
