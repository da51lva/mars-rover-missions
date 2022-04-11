package com.techreturners.marsroverkata.app;

import com.techreturners.marsroverkata.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverControllerTest {

    MarsRoverController marsRoverController;

    @BeforeEach
    public void setUp() {
        marsRoverController = new MarsRoverController();
    }

    @ParameterizedTest
    @MethodSource("generateDataForTestSingleRoverMovingEastWithinLargePlateau")
    public void testSingleRoverMovingEastWithinLargePlateau(int expectedX, int expectedY, int roverStartingX, int roverStartingY, List<Move> moves) {

        marsRoverController.addPlateau(PlateauFactory.createNurseryPlateau(1000, 1000));
        marsRoverController.addRover(roverStartingX,roverStartingY, Orientation.E);

        marsRoverController.moveCurrentRover(moves);
        assertEquals(expectedX, marsRoverController.getCurrentRoverPosition().getX());
        assertEquals(expectedY,  marsRoverController.getCurrentRoverPosition().getY());
    }

    @ParameterizedTest
    @MethodSource("generateDataForTestSingleRoverMovingInGivenOrientationWithinLargePlateau")
    public void testSingleRoverMovingInGivenOrientationWithinLargePlateau(int expectedX, int expectedY, int roverStartingX, int roverStartingY, Orientation startingOrientation, List<Move> moves) {
        marsRoverController.addPlateau(PlateauFactory.createNurseryPlateau(1000, 1000));
        marsRoverController.addRover(roverStartingX,roverStartingY, startingOrientation);

        marsRoverController.moveCurrentRover(moves);
        assertEquals(expectedX, marsRoverController.getCurrentRoverPosition().getX());
        assertEquals(expectedY,  marsRoverController.getCurrentRoverPosition().getY());
    }

    @ParameterizedTest
    @MethodSource("generateDataForTestSingleRoverWithLAndRMovesWithinLargePlateau")
    public void testSingleRoverWithLAndRMovesWithinLargePlateau(int expectedX, int expectedY, Orientation expectedOrientation, int roverStartingX, int roverStartingY, Orientation startingOrientation, List<Move> moves) {

        marsRoverController.addPlateau(PlateauFactory.createNurseryPlateau(1000, 1000));
        marsRoverController.addRover(roverStartingX,roverStartingY, startingOrientation);

        marsRoverController.moveCurrentRover(moves);
        assertEquals(expectedX, marsRoverController.getCurrentRoverPosition().getX());
        assertEquals(expectedY,  marsRoverController.getCurrentRoverPosition().getY());
        assertEquals(expectedOrientation, marsRoverController.getCurrentRoverOrientation());
    }

    @ParameterizedTest
    @MethodSource("generateDataForTestSingleRoverWithLRAndMMovesWithinLargePlateau")
    public void testSingleRoverWithLRAndMMovesWithinLargePlateau(int expectedX, int expectedY, Orientation expectedOrientation, int roverStartingX, int roverStartingY, Orientation startingOrientation, List<Move> moves) {

        marsRoverController.addPlateau(PlateauFactory.createNurseryPlateau(1000, 1000));
        marsRoverController.addRover(roverStartingX,roverStartingY, startingOrientation);

        marsRoverController.moveCurrentRover(moves);
        assertEquals(expectedX, marsRoverController.getCurrentRoverPosition().getX());
        assertEquals(expectedY,  marsRoverController.getCurrentRoverPosition().getY());
        assertEquals(expectedOrientation, marsRoverController.getCurrentRoverOrientation());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/single-rover-moving-out-of-nursery-plateau.csv", numLinesToSkip = 1)
    public void testSingleRoverMovingOutOfNurseryPlateau(int expectedX, int expectedY, String expectedOrientation, int xMax, int yMax, int roverStartingX, int roverStartingY, String startingOrientation, String moves) {

        marsRoverController.addPlateau(PlateauFactory.createNurseryPlateau(xMax, yMax));
        marsRoverController.addRover(roverStartingX,roverStartingY, Orientation.valueOf(startingOrientation));

        marsRoverController.moveCurrentRover(toListOfMoves(moves));
        assertEquals(expectedX, marsRoverController.getCurrentRoverPosition().getX());
        assertEquals(expectedY,  marsRoverController.getCurrentRoverPosition().getY());
        assertEquals(Orientation.valueOf(expectedOrientation), marsRoverController.getCurrentRoverOrientation());
    }

    //Todo: Test Rover Starting position not within Plateau
    //Todo: Test plateau of size 0
    //Todo: Test adding rover when plateau is full
    //Todo: throw exception if rover position is out of Bounds

    /**
     * Converts a list of moves represented as String to a List of Enumerations Move
     */
    private List<Move> toListOfMoves(String input){
        return Arrays.stream(input.split("")).map(Move::valueOf).collect(Collectors.toList());
    }

    private static Stream<Arguments> generateDataForTestSingleRoverMovingEastWithinLargePlateau() {
        return Stream.of(
                Arguments.of(1, 0, 0, 0, List.of(Move.M)),
                Arguments.of(5, 0, 0, 0, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(10, 0, 5, 0, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(10, 5, 5, 5, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(27, 50, 20, 50, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M, Move.M, Move.M))
        );
    }

    private static Stream<Arguments> generateDataForTestSingleRoverMovingInGivenOrientationWithinLargePlateau() {
        return Stream.of(
                Arguments.of(15, 10, 10, 10, Orientation.E, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(10, 15, 10, 10, Orientation.N, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(10, 5, 10, 10, Orientation.S, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M)),
                Arguments.of(5, 10, 10, 10, Orientation.W, Arrays.asList(Move.M, Move.M, Move.M, Move.M, Move.M))
        );
    }

    private static Stream<Arguments> generateDataForTestSingleRoverWithLAndRMovesWithinLargePlateau(){
        return Stream.of(
                Arguments.of(10, 10, Orientation.W, 10, 10, Orientation.N, List.of(Move.L)),
                Arguments.of(10, 10, Orientation.S, 10, 10, Orientation.N, Arrays.asList(Move.L,Move.L)),
                Arguments.of(10, 10, Orientation.E, 10, 10, Orientation.N, Arrays.asList(Move.L,Move.L,Move.L)),
                Arguments.of(10, 10, Orientation.N, 10, 10, Orientation.N, Arrays.asList(Move.L,Move.L,Move.L,Move.L)),
                Arguments.of(10, 10, Orientation.E, 10, 10, Orientation.N, List.of(Move.R)),
                Arguments.of(10, 10, Orientation.S, 10, 10, Orientation.N, Arrays.asList(Move.R, Move.R)),
                Arguments.of(10, 10, Orientation.W, 10, 10, Orientation.N, Arrays.asList(Move.R, Move.R,Move.R)),
                Arguments.of(10, 10, Orientation.N, 10, 10, Orientation.N, Arrays.asList(Move.R, Move.R,Move.R,Move.R)),

                Arguments.of(10, 10, Orientation.E, 10, 10, Orientation.E, Arrays.asList(Move.L,Move.L,Move.R,Move.R)),
                Arguments.of(10, 10, Orientation.N, 10, 10, Orientation.S, Arrays.asList(Move.L,Move.L)),
                Arguments.of(10, 10, Orientation.E, 10, 10, Orientation.W, Arrays.asList(Move.L,Move.R,Move.R,Move.L,Move.L,Move.L,Move.L,Move.R))
        );
    }

    private static Stream<Arguments> generateDataForTestSingleRoverWithLRAndMMovesWithinLargePlateau(){
        return Stream.of(
                Arguments.of(1, 3, Orientation.N, 1, 2, Orientation.N, Arrays.asList(Move.L, Move.M,Move.L,Move.M,Move.L,Move.M,Move.L,Move.M,Move.M)),
                Arguments.of(5, 1, Orientation.E, 3, 3, Orientation.E, Arrays.asList(Move.M,Move.M,Move.R,Move.M,Move.M,Move.R,Move.M,Move.R,Move.R,Move.M)),
                Arguments.of(12 , 4, Orientation.S, 10, 10, Orientation.S, Arrays.asList(Move.M,Move.M,Move.M,Move.M,Move.L,Move.M,Move.M,Move.R,Move.M,Move.M)),
                Arguments.of(103, 11, Orientation.W, 100, 10, Orientation.W, Arrays.asList(Move.L,Move.L,Move.M,Move.M,Move.L,Move.M,Move.R,Move.M,Move.R,Move.R))
        );
    }

}