package com.techreturners.marsroverkata.model;

public class MarsRover implements Rover {

    private Position position;
    private Orientation orientation;

    public MarsRover(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }


    @Override
    public void orientateRight() {
        orientation = orientation.next();
    }

    @Override
    public void orientateLeft() {
        orientation = orientation.prev();
    }

    @Override
    public Position getMoveTranslation() {
        return orientation.getTranslation();
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

}
