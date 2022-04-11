package com.techreturners.marsroverkata.model;

public enum Orientation {
    N(0, 1),
    E(1, 0),
    S(0, -1),
    W(-1, 0);

    private Position translation;

    Orientation(int dx, int dy) {
        translation = new Position(dx, dy);
    }

    public Orientation next() {
        return values()[(this.ordinal() + values().length + 1) % values().length]; //cycles round Enum
    }

    public Orientation prev() {
        return values()[(this.ordinal() + values().length - 1) % values().length]; //cycles round Enum
    }

    public Position getTranslation() {
        return translation;
    }
}
