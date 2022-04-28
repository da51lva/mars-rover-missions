package matt.thewizard.techreturners.marsrovermissions.model;

public interface Rover {


    int getId();

    Position getPosition();

    Orientation getOrientation();

    void orientateRight();

    void orientateLeft();

    Position getMoveTranslation();

    void setPosition(Position position);
}
