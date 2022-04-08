package com.techreturners.marsroverkata.model;

public class MarsRover implements Rover {

    private int xPosition;
    private int yPosition;
    private Orientation orientation;

    public MarsRover(int xPosition, int yPosition, Orientation orientation) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.orientation = orientation;
    }


    @Override
    public int getXPosition() {
        return xPosition;
    }

    @Override
    public int getYPosition() {
        return yPosition;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public void move() {
        xPosition += orientation.getDx();
        yPosition += orientation.getDy();
    }

    @Override
    public void orientateRight() {
        orientation = orientation.next();
    }

    @Override
    public void orientateLeft() {
        orientation = orientation.prev();
    }

}
