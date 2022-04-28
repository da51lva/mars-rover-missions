package matt.thewizard.techreturners.marsrovermissions.app;

import matt.thewizard.techreturners.marsrovermissions.model.MarsRoverModel;
import matt.thewizard.techreturners.marsrovermissions.model.Move;
import matt.thewizard.techreturners.marsrovermissions.model.Orientation;
import matt.thewizard.techreturners.marsrovermissions.model.Rover;
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

class MarsRoverModelTest {

    MarsRoverModel marsRoverModel;

    @BeforeEach
    public void setUp() {
        marsRoverModel = new MarsRoverModel();
    }

    @ParameterizedTest
    @MethodSource("generateDataForTestSingleRoverMovingEastWithinLargePlateau")
    public void testSingleRoverMovingEastWithinLargePlateau(int expectedX, int expectedY, int roverStartingX, int roverStartingY, List<Move> moves) {

        marsRoverModel.createPlateau(1000, 1000);
        marsRoverModel.addRover(roverStartingX, roverStartingY, Orientation.E);

        marsRoverModel.moveRover(1,moves);
        checkRoverResult(1,expectedX, expectedY,"E");
    }

    @ParameterizedTest
    @MethodSource("generateDataForTestSingleRoverMovingInGivenOrientationWithinLargePlateau")
    public void testSingleRoverMovingInGivenOrientationWithinLargePlateau(int expectedX, int expectedY, int roverStartingX, int roverStartingY, Orientation startingOrientation, List<Move> moves) {
        marsRoverModel.createPlateau(1000, 1000);
        marsRoverModel.addRover(roverStartingX, roverStartingY, startingOrientation);

        marsRoverModel.moveRover(1,moves);
        checkRoverResult(1,expectedX, expectedY,startingOrientation.toString());
    }

    @ParameterizedTest
    @MethodSource("generateDataForTestSingleRoverWithLAndRMovesWithinLargePlateau")
    public void testSingleRoverWithLAndRMovesWithinLargePlateau(int expectedX, int expectedY, Orientation expectedOrientation, int roverStartingX, int roverStartingY, Orientation startingOrientation, List<Move> moves) {

        marsRoverModel.createPlateau(1000, 1000);
        marsRoverModel.addRover(roverStartingX, roverStartingY, startingOrientation);

        marsRoverModel.moveRover(1,moves);
        checkRoverResult(1,expectedX,expectedY,expectedOrientation.toString());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/single-rover-all-moves.csv", numLinesToSkip = 1)
    public void testSingleRoverWithLRAndMMovesWithinLargePlateau(int roverStartingX, int roverStartingY, String startingOrientation, String moves, int expectedX, int expectedY, String expectedOrientation) {
        takeFullTurn(1,1000, 1000, roverStartingX, roverStartingY, startingOrientation, moves);
        checkRoverResult(1,expectedX, expectedY, expectedOrientation);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/single-rover-moving-out-of-nursery-plateau.csv", numLinesToSkip = 1)
    public void testSingleRoverMovingOutOfNurseryPlateau(int expectedX, int expectedY, String expectedOrientation, int xMax, int yMax, int roverStartingX, int roverStartingY, String startingOrientation, String moves) {
        takeFullTurn(1, xMax, yMax, roverStartingX, roverStartingY, startingOrientation, moves);
        checkRoverResult(1, expectedX, expectedY, expectedOrientation);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/second-rover-input.csv", numLinesToSkip = 1)
    public void testSecondRoverWithinNurseryPlateau(int rover1X, int rover1Y, String rover1Orientation, String rover1Moves, int rover2X, int rover2Y, String rover2Orientation, String rover2Moves, int rover2ExpectedX, int rover2ExpectedY, String rover2ExpectedOrientation) {
        takeFullTurn(1,1000, 1000, rover1X, rover1Y, rover1Orientation, rover1Moves);
        takeRoverTurn(2,rover2X, rover2Y, rover2Orientation, rover2Moves);
        checkRoverResult(2,rover2ExpectedX, rover2ExpectedY, rover2ExpectedOrientation);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/second-rover-collision.csv", numLinesToSkip = 1)
    public void testSecondRoverBumpingIntoFirstWithinNurseryPlateau(int rover2X, int rover2Y, String rover2Orientation, String rover2Moves, int rover2ExpectedX, int rover2ExpectedY, String rover2ExpectedOrientation) {
        takeFullTurn(1,1000, 1000, 5, 5, "N", "L");
        takeRoverTurn(2,rover2X, rover2Y, rover2Orientation, rover2Moves);
        checkRoverResult(2,rover2ExpectedX, rover2ExpectedY, rover2ExpectedOrientation);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/single-rover-starting-position-out-of-bounds.csv", numLinesToSkip = 1)
    public void testRoverStartingPositionOutOfNurseryPlateau(int x, int y) {
        marsRoverModel.createPlateau(10, 10);
        marsRoverModel.addRover(x, y, Orientation.N);
        checkRoverResult(1,0, 0, "N");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/rover-starting-position-taken.csv", numLinesToSkip = 1)
    public void testRoverStartingPositionTakenNurseryPlateau(int xMax, int yMax, String roverStartingPositions, int lastX, int lastY, int expectedX, int expectedY) {
        marsRoverModel.createPlateau(xMax, yMax);
        Arrays.stream(roverStartingPositions.split(";"))
                .forEach(e -> {
                    String[] split = e.split(":");
                    marsRoverModel.addRover(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Orientation.N);
                });

        marsRoverModel.addRover(lastX, lastY, Orientation.N);
        checkRoverResult(marsRoverModel.getRovers().size(),expectedX, expectedY, "N");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/plateau-full.csv", numLinesToSkip = 1)
    public void testPlateauFull(int xMax, int yMax, String roverStartingPositions) {
        marsRoverModel.createPlateau(xMax, yMax);
        Arrays.stream(roverStartingPositions.split(";"))
                .forEach(e -> {
                    String[] split = e.split(":");
                    marsRoverModel.addRover(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Orientation.N);
                });

        marsRoverModel.addRover(0, 0, Orientation.N);
        assertEquals((xMax+1) * (yMax + 1),marsRoverModel.getRovers().size());
    }

    private void takeFullTurn(int roverId, int xMax, int yMax, int x, int y, String orientation, String moves) {
        marsRoverModel.createPlateau(xMax, yMax);
        takeRoverTurn(roverId, x, y, orientation, moves);
    }

    private void takeRoverTurn(int roverId, int x, int y, String orientation, String moves) {
        marsRoverModel.addRover(x, y, Orientation.valueOf(orientation));
        marsRoverModel.moveRover(roverId,toListOfMoves(moves));
    }

    private void checkRoverResult(int roverId, int expectedX, int expectedY, String expectedOrientation) {
        Rover rover = marsRoverModel.getRover(roverId);
        assertEquals(expectedX, rover.getPosition().getX());
        assertEquals(expectedY, rover.getPosition().getY());
        assertEquals(Orientation.valueOf(expectedOrientation), rover.getOrientation());
    }

    //Todo: cant move rover that didn't get added to plateau
    //Todo: Test plateau of size 0
    //Todo: empty move list

    /**
     *Converts a list of moves represented as String to a List of Enumerations Move
     */
    private List<Move> toListOfMoves(String input) {
        return Arrays.stream(input.split(""))
                .map(Move::valueOf)
                .collect(Collectors.toList());
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

    private static Stream<Arguments> generateDataForTestSingleRoverWithLAndRMovesWithinLargePlateau() {
        return Stream.of(
                Arguments.of(10, 10, Orientation.W, 10, 10, Orientation.N, List.of(Move.L)),
                Arguments.of(10, 10, Orientation.S, 10, 10, Orientation.N, Arrays.asList(Move.L, Move.L)),
                Arguments.of(10, 10, Orientation.E, 10, 10, Orientation.N, Arrays.asList(Move.L, Move.L, Move.L)),
                Arguments.of(
                        10,
                        10,
                        Orientation.N,
                        10,
                        10,
                        Orientation.N,
                        Arrays.asList(Move.L, Move.L, Move.L, Move.L)
                ),
                Arguments.of(10, 10, Orientation.E, 10, 10, Orientation.N, List.of(Move.R)),
                Arguments.of(10, 10, Orientation.S, 10, 10, Orientation.N, Arrays.asList(Move.R, Move.R)),
                Arguments.of(10, 10, Orientation.W, 10, 10, Orientation.N, Arrays.asList(Move.R, Move.R, Move.R)),
                Arguments.of(
                        10,
                        10,
                        Orientation.N,
                        10,
                        10,
                        Orientation.N,
                        Arrays.asList(Move.R, Move.R, Move.R, Move.R)
                ),

                Arguments.of(
                        10,
                        10,
                        Orientation.E,
                        10,
                        10,
                        Orientation.E,
                        Arrays.asList(Move.L, Move.L, Move.R, Move.R)
                ),
                Arguments.of(10, 10, Orientation.N, 10, 10, Orientation.S, Arrays.asList(Move.L, Move.L)),
                Arguments.of(
                        10,
                        10,
                        Orientation.E,
                        10,
                        10,
                        Orientation.W,
                        Arrays.asList(Move.L, Move.R, Move.R, Move.L, Move.L, Move.L, Move.L, Move.R)
                )
        );
    }

}