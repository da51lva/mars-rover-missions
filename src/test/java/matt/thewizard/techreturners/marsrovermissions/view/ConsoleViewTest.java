package matt.thewizard.techreturners.marsrovermissions.view;

import matt.thewizard.techreturners.marsrovermissions.model.MarsRover;
import matt.thewizard.techreturners.marsrovermissions.model.Orientation;
import matt.thewizard.techreturners.marsrovermissions.model.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.Console;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ConsoleViewTest {

    @Test
    void displayGrid() {
        ConsoleView consoleView = new ConsoleView(null);
        consoleView.displayGrid(10, 4, List.of(
                new MarsRover(new Position(0, 0), Orientation.N),
                new MarsRover(new Position(1, 1), Orientation.S),
                new MarsRover(new Position(2, 2), Orientation.E),
                new MarsRover(new Position(10, 4), Orientation.W)
        ));
    }

    @Test
    void displayGridTwo() {
        ConsoleView consoleView = new ConsoleView(null);
        consoleView.displayGrid(0, 0, List.of(
                new MarsRover(new Position(0, 0), Orientation.N)
        ));
    }
}