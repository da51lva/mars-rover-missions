package com.techreturners.marsroverkata.app;

import com.techreturners.marsroverkata.model.MarsRover;
import com.techreturners.marsroverkata.model.Move;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverControllerTest {

    private static Stream<Arguments> generateDataForTestSingleRoverInfinitePlateauOnlyMoveEast() {
        return Stream.of(
                Arguments.of(1, 0, 0, 0, Arrays.asList(Move.M)),
                Arguments.of(5, 0, 0, 0, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(10, 0, 5, 0, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(10, 5, 5, 5, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(27, 50, 20, 50, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M, Move.M, Move.M))
        );
    }

    @ParameterizedTest
    @MethodSource("generateDataForTestSingleRoverInfinitePlateauOnlyMoveEast")
    public void testSingleRoverInfinitePlateauOnlyMoveEast(int expectedX, int expectedY, int roverStartingX, int roverStartingY, List<Move> moves) {
        MarsRoverController marsRoverController = new MarsRoverController();
        marsRoverController.addRover(new MarsRover(roverStartingX, roverStartingY));
        marsRoverController.moveCurrentRover(moves);
        assertEquals(expectedX, marsRoverController.getCurrentRover().getPosition().getX());
        assertEquals(expectedY, marsRoverController.getCurrentRover().getPosition().getY());
    }

}