package com.techreturners.marsroverkata.model;

public interface Rover {


    Orientation getOrientation();

    void orientateRight();

    void orientateLeft();

    Position getMoveTranslation();
}
