package com.techreturners.marsroverkata.model;

public interface Rover {


    Position getPosition();

    Orientation getOrientation();

    void orientateRight();

    void orientateLeft();

    Position getMoveTranslation();

    void setPosition(Position position);
}
