package com.techreturners.marsroverkata.model;

import java.util.HashMap;
import java.util.Map;

public class NurseryPlateau implements Plateau {

    private static final int xMin = 0;
    private static final int yMin = 0;

    private final int xMax;
    private final int yMax;

    private final Map<Rover, Position> roverPositions = new HashMap();

    public NurseryPlateau(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }

    @Override
    public void addNewRover(Rover rover, Position startingPosition) {
        if (isFull())
            return;
        if (isOutOfBounds(startingPosition) || isTaken(startingPosition))
            addToNextFreePosition(rover, new Position(xMin, yMin));
        else
            roverPositions.put(rover, startingPosition);
    }

    private boolean isFull() {
        return  roverPositions.size() == (xMax + 1) * (yMax + 1);
    }

    private void addToNextFreePosition(Rover rover, Position position) {
        if (isTaken(position))
            addToNextFreePosition(rover, incrementPosition(position));
        else
            roverPositions.put(rover, position);

    }

    private Position incrementPosition(Position position) {
        int y = position.getY();
        int x = position.getX();
        if (x + 1 <= xMax)
            return new Position(x + 1, y);
        else
            return new Position(xMin, y + 1); //wrap to nex y
    }


    @Override
    public void moveRover(Rover rover) {
        Position translation = rover.getMoveTranslation();
        Position newPosition = Position.translate(roverPositions.get(rover), translation);
        if (isOutOfBounds(newPosition))
            ;//todo: store event
        else if (isTaken(newPosition))
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
        boolean xOutOfBounds = position.getX() < xMin || position.getX() > xMax;
        boolean yOutOfBounds = position.getY() < yMin || position.getY() > yMax;
        return xOutOfBounds || yOutOfBounds;
    }


}