package com.techreturners.marsroverkata.model;

import java.util.HashMap;
import java.util.Map;

public class NurseryPlateau implements Plateau{

    private static final int xMin = 0;
    private static final int yMin = 0;

    private final int xMAx;
    private final int yMax;

    private final Map<Rover, Position> roverPositions = new HashMap();

    public NurseryPlateau(int xMAx, int yMax) {
        this.xMAx = xMAx;
        this.yMax = yMax;
    }

    @Override
    public void addNewRover(Rover rover, Position startingPosition) {
        roverPositions.put(rover, startingPosition);
    }

    @Override
    public void moveRover(Rover rover) {
        Position translation = rover.getMoveTranslation();
        Position newPosition = Position.translate(roverPositions.get(rover),translation);
        if(isOutOfBounds(newPosition))
            ;//todo: store event
        else if(isTaken(newPosition))
            ;//todo: store event
        else
            roverPositions.put(rover, newPosition);
    }

    private boolean isTaken(Position newPosition) {
        return roverPositions.containsValue(newPosition);
    }

    @Override
    public Position getRoverPosition(Rover rover) {
        return roverPositions.get(rover);
    }

    private boolean isOutOfBounds(Position position) {
        boolean xOutOfBounds = position.getX() < xMin || position.getX() > xMAx;
        boolean yOutOfBounds = position.getY() < yMin || position.getY() > yMax;
        return xOutOfBounds || yOutOfBounds;
    }

}