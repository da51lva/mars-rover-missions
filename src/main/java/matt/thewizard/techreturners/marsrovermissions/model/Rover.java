package matt.thewizard.techreturners.marsrovermissions.model;

public interface Rover {


    Position getPosition();

    Orientation getOrientation();

    void orientateRight();

    void orientateLeft();

    Position getMoveTranslation();

    void setPosition(Position position);
}
