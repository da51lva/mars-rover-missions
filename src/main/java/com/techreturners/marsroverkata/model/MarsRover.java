package com.techreturners.marsroverkata.model;

public class MarsRover implements Rover {

    private Orientation orientation;

    public MarsRover(Orientation orientation) {
        this.orientation = orientation;
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

}
