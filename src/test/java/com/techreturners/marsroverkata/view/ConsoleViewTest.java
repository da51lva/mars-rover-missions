package com.techreturners.marsroverkata.view;

import com.techreturners.marsroverkata.model.MarsRover;
import com.techreturners.marsroverkata.model.Orientation;
import com.techreturners.marsroverkata.model.Position;
import org.junit.jupiter.api.Test;

import java.util.Map;

class ConsoleViewTest {

    @Test
    void displayGrid() {
        ConsoleView consoleView = new ConsoleView();
        consoleView.displayGrid(0, 0, 10, 4, Map.of(
                new MarsRover(Orientation.N),
                new Position(0, 0),
                new MarsRover(Orientation.N),
                new Position(1, 1),
                new MarsRover(Orientation.N),
                new Position(2, 2)
        ));
    }
}