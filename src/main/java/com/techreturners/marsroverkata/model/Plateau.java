package com.techreturners.marsroverkata.model;

public interface Plateau {


    void addNewRover(Rover rover, Position startingPosition);

    void moveRover(Rover currentRover);

    Position getRoverPosition(Rover rover);
}
