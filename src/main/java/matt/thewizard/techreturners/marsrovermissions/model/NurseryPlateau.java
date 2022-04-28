package matt.thewizard.techreturners.marsrovermissions.model;

import java.util.*;

public class NurseryPlateau implements Plateau {

    private static final int xMin = 0;
    private static final int yMin = 0;

    private final int xMax;
    private final int yMax;

    private final List<Rover> rovers = new ArrayList<>();
    private final Set<Position> takenPositions = new HashSet<>();

    public NurseryPlateau(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }

    @Override
    public Rover getRover(int id) {
        return rovers.get(id-1);
    }

    @Override
    public List<Rover> getRovers() {
        return rovers;
    }

    @Override
    public void createNewRover(int x, int y, Orientation orientation) {
        Position startingPosition = new Position(x,y);
        if (isFull())
            ; //TODO: store event
        else if(isOutOfBounds(startingPosition) || isTaken(startingPosition))
            createRoverAtNextFreePosition(new Position(xMin, yMin), orientation);
        else{
            Rover rover = new MarsRover(startingPosition,orientation);
            takenPositions.add(startingPosition);
            rovers.add(rover);
        }
    }

    @Override
    public int getXMax() {
        return xMax;
    }

    @Override
    public int getYMax() {
        return yMax;
    }

    @Override
    public void moveRover(Rover rover) {
        Position currentPosition = rover.getPosition();
        Position translation = rover.getMoveTranslation();
        Position newPosition = Position.translate(currentPosition, translation);
        if (isOutOfBounds(newPosition))
            ;//todo: store event
        else if (isTaken(newPosition))
            ;//todo: store event
        else {
            takenPositions.remove(currentPosition);
            rover.setPosition(newPosition);
            takenPositions.add(newPosition);
        }
    }

    private void createRoverAtNextFreePosition(Position position, Orientation orientation) {
        if (isTaken(position))
            createRoverAtNextFreePosition(incrementPosition(position), orientation);
        else {
            Rover rover = new MarsRover(position,orientation);
            takenPositions.add(position);
            rovers.add(rover);
        }
    }

    private boolean isFull() {
        return  takenPositions.size() == (xMax + 1) * (yMax + 1);
    }

    private Position incrementPosition(Position position) {
        int y = position.getY();
        int x = position.getX();
        if (x + 1 <= xMax)
            return new Position(x + 1, y);
        else
            return new Position(xMin, y + 1); //wrap to nex y
    }


    private boolean isTaken(Position position) {
        return takenPositions.contains(position);
    }

    private boolean isOutOfBounds(Position position) {
        boolean xOutOfBounds = position.getX() < xMin || position.getX() > xMax;
        boolean yOutOfBounds = position.getY() < yMin || position.getY() > yMax;
        return xOutOfBounds || yOutOfBounds;
    }


}