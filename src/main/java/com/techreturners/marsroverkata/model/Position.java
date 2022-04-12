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

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Position or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Position)) {
            return false;
        }

        // typecast o to Position so that we can compare data members
        Position p = (Position) o;

        // Compare x and y valus
        return this.x == p.x && this.y == p.y;
    }

    /**
     * Utility function - Returns a new Position given an origin and a translation
     */
    public static Position translate(Position origin, Position translation){
        return new Position( origin.getX() + translation.getX(), origin.getY() + translation.getY());
    }
}
