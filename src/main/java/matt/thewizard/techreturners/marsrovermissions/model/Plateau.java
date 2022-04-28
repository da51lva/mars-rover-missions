package matt.thewizard.techreturners.marsrovermissions.model;

import java.util.List;

public interface Plateau {

    Rover getRover(int id);

    List<Rover> getRovers();

    void moveRover(Rover currentRover);

    void createNewRover(int x, int y, Orientation orientation);

    int getXMax();

    int getYMax();
}
