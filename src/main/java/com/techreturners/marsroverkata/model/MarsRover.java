package com.techreturners.marsroverkata.model;

import java.awt.*;

public class MarsRover implements Rover {

    private Point position;

    public MarsRover(int x, int y) {
        this.position = new Point(x,y);
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void move(Move move) {
        position.translate(1,0);
    }
}
