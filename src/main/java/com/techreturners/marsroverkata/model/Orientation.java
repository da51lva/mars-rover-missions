package com.techreturners.marsroverkata.model;

import java.awt.*;

public enum Orientation {
    N(0,1),
    S(0,-1),
    E(1,0),
    W(-1,0);


    private Point translation;

    Orientation(int dx, int dy) {
        this.translation = new Point(dx,dy);
    }

    public Point getTranslation() {
        return translation;
    }
}
