package com.techreturners.marsroverkata.model;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Utility function - Returns a new Position given an origin and a translation
     */
    public static Position translate(Position origin, Position translation){
        return new Position( origin.getX() + translation.getX(), origin.getY() + translation.getY());
    }
}
