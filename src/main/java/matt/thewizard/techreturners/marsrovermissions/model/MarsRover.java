package matt.thewizard.techreturners.marsrovermissions.model;

public class MarsRover implements Rover {

    private static int nextId = 1;

    private final int id;

    private Position position;
    private Orientation orientation;

    public MarsRover(Position position, Orientation orientation) {
        id = nextId;
        nextId++;
        this.position = position;
        this.orientation = orientation;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }


    @Override
    public void orientateRight() {
        orientation = orientation.next();
    }

    @Override
    public void orientateLeft() {
        orientation = orientation.prev();
    }

    @Override
    public Position getMoveTranslation() {
        return orientation.getTranslation();
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

}
