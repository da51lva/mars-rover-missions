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
        Point translation = orientation.getTranslation();
        position.translate((int) translation.getX(), (int) translation.getY()); //TODO: not sure about using Point
    }
}
