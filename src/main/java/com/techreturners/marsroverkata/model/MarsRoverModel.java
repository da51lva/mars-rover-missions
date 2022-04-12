package com.techreturners.marsroverkata.model;

import java.util.List;

public class MarsRoverModel {

    private Plateau plateau;

    private Rover currentRover;


    public void createPlateau(int xMax, int yMax){
        this.plateau = new NurseryPlateau(xMax, yMax);
    }

    public void addRover(int x, int y, Orientation orientation) {
        currentRover = new MarsRover(orientation);
        plateau.addNewRover(currentRover, new Position(x, y));
    }

    public Position getCurrentRoverPosition() {
        return plateau.getRoverPosition(currentRover);
    }

    public Orientation getCurrentRoverOrientation(){
        return currentRover.getOrientation();
    }

    public void moveCurrentRover(List<Move> moves) {
        moves.stream()
                .forEach(this::moveCurrentRover);
    }

    private void moveCurrentRover(Move move) {
        switch (move) {
            case M:
                plateau.moveRover(currentRover);
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
