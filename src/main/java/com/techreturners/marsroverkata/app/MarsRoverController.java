package com.techreturners.marsroverkata.app;

import com.techreturners.marsroverkata.model.Move;
import com.techreturners.marsroverkata.model.Rover;

import java.util.List;

public class MarsRoverController {

    private Rover currentRover;

    public void addRover(Rover rover){
        currentRover = rover;
    }

    public Rover getCurrentRover(){
        return currentRover;
    }

    public void moveCurrentRover(List<Move> moves) {
        moves.stream().forEach(currentRover::move);
    }
}
