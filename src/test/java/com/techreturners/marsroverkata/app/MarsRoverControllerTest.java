package com.techreturners.marsroverkata.app;

import com.techreturners.marsroverkata.model.MarsRover;
import com.techreturners.marsroverkata.model.Move;
import com.techreturners.marsroverkata.model.Orientation;
import com.techreturners.marsroverkata.model.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverControllerTest {

    MarsRoverController marsRoverController;


    @BeforeEach
    public void setUp() {
        marsRoverController = new MarsRoverController();
    }

    @ParameterizedTest
    @MethodSource("generateDataForTestSingleRoverInfinitePlateauOnlyMoveEast")
    public void testSingleRoverInfinitePlateauOnlyMoveEast(int expectedX, int expectedY, int roverStartingX, int roverStartingY, List<Move> moves) {

        marsRoverController.addRover(new MarsRover(roverStartingX, roverStartingY, Orientation.E));
        marsRoverController.moveCurrentRover(moves);
        assertEquals(expectedX, marsRoverController.getCurrentRover().getPosition().getX());
        assertEquals(expectedY, marsRoverController.getCurrentRover().getPosition().getY());
    }

    @ParameterizedTest
    @MethodSource("generateDataForTestSingleRoverInfinitePlateauWithOrientation")
    public void testSingleRoverInfinitePlateauWithOrientation(int expectedX, int expectedY, int roverStartingX, int roverStartingY, Orientation startingOrientation, List<Move> moves) {
        marsRoverController.addRover(new MarsRover(roverStartingX, roverStartingY, startingOrientation));
        marsRoverController.moveCurrentRover(moves);
        assertEquals(expectedX, marsRoverController.getCurrentRover().getPosition().getX());
        assertEquals(expectedY, marsRoverController.getCurrentRover().getPosition().getY());
    }

    @ParameterizedTest
    @MethodSource("generateDataForTestSingleRoverInfinitePlateauWithOrientationMoves")
    public void testSingleRoverInfinitePlateauWithOrientationMoves(int expectedX, int expectedY, Orientation expectedOrientation, int roverStartingX, int roverStartingY, Orientation startingOrientation, List<Move> moves) {

        marsRoverController.addRover(new MarsRover(roverStartingX, roverStartingY, startingOrientation));
        marsRoverController.moveCurrentRover(moves);
        Rover rover = marsRoverController.getCurrentRover();
        assertEquals(expectedX, rover.getPosition().getX());
        assertEquals(expectedY, rover.getPosition().getY());
        assertEquals(expectedOrientation, rover.getOrientation());
    }

    @ParameterizedTest
    @MethodSource("generateDataForTestSingleRoverInfinitePlateauWithLRAndMMoves")
    public void testSingleRoverInfinitePlateauWithLRAndMMoves(int expectedX, int expectedY, Orientation expectedOrientation, int roverStartingX, int roverStartingY, Orientation startingOrientation, List<Move> moves) {

        marsRoverController.addRover(new MarsRover(roverStartingX, roverStartingY, startingOrientation));
        marsRoverController.moveCurrentRover(moves);
        Rover rover = marsRoverController.getCurrentRover();
        assertEquals(expectedX, rover.getPosition().getX());
        assertEquals(expectedY, rover.getPosition().getY());
        assertEquals(expectedOrientation, rover.getOrientation());
    }

    private static Stream<Arguments> generateDataForTestSingleRoverInfinitePlateauOnlyMoveEast() {
        return Stream.of(
                Arguments.of(1, 0, 0, 0, Arrays.asList(Move.M)),
                Arguments.of(5, 0, 0, 0, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(10, 0, 5, 0, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(10, 5, 5, 5, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(27, 50, 20, 50, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M, Move.M, Move.M))
        );
    }

    private static Stream<Arguments> generateDataForTestSingleRoverInfinitePlateauWithOrientation() {
        return Stream.of(
                Arguments.of(15, 10, 10, 10, Orientation.E, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(10, 15, 10, 10, Orientation.N, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(10, 5, 10, 10, Orientation.S, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(5, 10, 10, 10, Orientation.W, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M))
        );
    }

    private static Stream<Arguments> generateDataForTestSingleRoverInfinitePlateauWithOrientationMoves(){
        return Stream.of(
                Arguments.of(10, 10, Orientation.W, 10, 10, Orientation.N, Arrays.asList(Move.L)),
                Arguments.of(10, 10, Orientation.S, 10, 10, Orientation.N, Arrays.asList(Move.L,Move.L)),
                Arguments.of(10, 10, Orientation.E, 10, 10, Orientation.N, Arrays.asList(Move.L,Move.L,Move.L)),
                Arguments.of(10, 10, Orientation.N, 10, 10, Orientation.N, Arrays.asList(Move.L,Move.L,Move.L,Move.L)),
                Arguments.of(10, 10, Orientation.E, 10, 10, Orientation.N, Arrays.asList(Move.R)),
                Arguments.of(10, 10, Orientation.S, 10, 10, Orientation.N, Arrays.asList(Move.R, Move.R)),
                Arguments.of(10, 10, Orientation.W, 10, 10, Orientation.N, Arrays.asList(Move.R, Move.R,Move.R)),
                Arguments.of(10, 10, Orientation.N, 10, 10, Orientation.N, Arrays.asList(Move.R, Move.R,Move.R,Move.R)),

                Arguments.of(10, 10, Orientation.E, 10, 10, Orientation.E, Arrays.asList(Move.L,Move.L,Move.R,Move.R)),
                Arguments.of(10, 10, Orientation.N, 10, 10, Orientation.S, Arrays.asList(Move.L,Move.L)),
                Arguments.of(10, 10, Orientation.E, 10, 10, Orientation.W, Arrays.asList(Move.L,Move.R,Move.R,Move.L,Move.L,Move.L,Move.L,Move.R))
        );
    }


    private static Stream<Arguments> generateDataForTestSingleRoverInfinitePlateauWithLRAndMMoves(){
        return Stream.of(
                Arguments.of(1, 3, Orientation.N, 1, 2, Orientation.N, Arrays.asList(Move.L, Move.M,Move.L,Move.M,Move.L,Move.M,Move.L,Move.M,Move.M)),
                Arguments.of(5, 1, Orientation.E, 3, 3, Orientation.E, Arrays.asList(Move.M,Move.M,Move.R,Move.M,Move.M,Move.R,Move.M,Move.R,Move.R,Move.M)),
                Arguments.of(12 , 4, Orientation.S, 10, 10, Orientation.S, Arrays.asList(Move.M,Move.M,Move.M,Move.M,Move.L,Move.M,Move.M,Move.R,Move.M,Move.M)),
                Arguments.of(103, 11, Orientation.W, 100, 10, Orientation.W, Arrays.asList(Move.L,Move.L,Move.M,Move.M,Move.L,Move.M,Move.R,Move.M,Move.R,Move.R))
        );
    }

}