package com.techreturners.marsroverkata.model;

import java.awt.*;

public class MarsRover implements Rover {

    private Point position;
    private Orientation orientation;

    public MarsRover(int x, int y, Orientation orientation) {
        this.position = new Point(x,y);
        this.orientation = orientation;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void move(Move move) {
        switch (move){
            case M:
                Point translation = orientation.getTranslation();
                position.translate((int) translation.getX(), (int) translation.getY()); //TODO: not sure about using Point
                break;
            case R:
                orientation = orientation.next();
                break;
            case L:
                orientation = orientation.prev();
                break;
        }
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }
}
