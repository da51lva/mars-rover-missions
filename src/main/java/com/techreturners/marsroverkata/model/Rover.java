package com.techreturners.marsroverkata.model;

import java.awt.*;

public interface Rover {

    int getXPosition();

    int getYPosition();

    Orientation getOrientation();

    void move();

    void orientateRight();

    void orientateLeft();
}
