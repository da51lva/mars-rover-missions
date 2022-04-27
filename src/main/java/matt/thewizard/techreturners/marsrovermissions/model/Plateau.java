package matt.thewizard.techreturners.marsrovermissions.model;

import java.util.List;

public interface Plateau {

    List<Rover> getRovers();

    void moveRover(Rover currentRover);

    Rover createNewRover(int x, int y, Orientation orientation);

    int getXMax();

    int getYMax();
}
