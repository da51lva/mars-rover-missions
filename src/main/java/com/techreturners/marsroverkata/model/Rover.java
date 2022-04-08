package com.techreturners.marsroverkata.model;

import java.awt.*;

public interface Rover {

    Point getPosition();

    void move(Move move);

    Orientation getOrientation();
}
