package matt.thewizard.techreturners.marsrovermissions.view;

import matt.thewizard.techreturners.marsrovermissions.model.MarsRover;
import matt.thewizard.techreturners.marsrovermissions.model.Orientation;
import matt.thewizard.techreturners.marsrovermissions.model.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

class ConsoleViewTest {

    @Test
    void displayGrid() {
        ConsoleView consoleView = new ConsoleView();
        consoleView.displayGrid(10, 4, List.of(
                new MarsRover(new Position(0, 0), Orientation.N),
                new MarsRover(new Position(1, 1), Orientation.N),
                new MarsRover(new Position(2, 2), Orientation.N)
        ));
    }
}