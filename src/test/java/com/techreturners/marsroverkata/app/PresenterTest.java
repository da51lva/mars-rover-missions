package com.techreturners.marsroverkata.app;

import com.techreturners.marsroverkata.model.MarsRoverModel;
import com.techreturners.marsroverkata.model.Move;
import com.techreturners.marsroverkata.model.Orientation;
import com.techreturners.marsroverkata.model.Position;
import com.techreturners.marsroverkata.presenter.Presenter;
import com.techreturners.marsroverkata.view.ConsoleView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PresenterTest {

    @Mock
    MarsRoverModel marsRoverController;
    @Mock
    ConsoleView consoleView;
    private Presenter presenter;

    @BeforeEach
    public void setUp() {
        presenter = new Presenter(marsRoverController, consoleView);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/presenter/valid-plateau-size-inputs.csv", numLinesToSkip = 1)
    public void testExecutePlateauSizeInputWithValidInputs(String input, int expectedXMax, int expectedYMax) {

        ArgumentCaptor<Integer> xCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> yCaptor = ArgumentCaptor.forClass(Integer.class);

        presenter.executePlateauSizeInput(input);
        verify(marsRoverController).createPlateau(xCaptor.capture(), yCaptor.capture());
        assertEquals(expectedXMax, xCaptor.getValue());
        assertEquals(expectedYMax, yCaptor.getValue());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/presenter/valid-rover-inputs.csv", numLinesToSkip = 1)
    public void testExecuteNewRoverInputWithValidInputs(String input, int expectedX, int expectedY, String expectedOrientation) {

        ArgumentCaptor<Integer> xCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> yCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Orientation> orientationCaptor = ArgumentCaptor.forClass(Orientation.class);

        presenter.executeNewRoverInput(input);
        verify(marsRoverController).addRover(xCaptor.capture(), yCaptor.capture(), orientationCaptor.capture());
        assertEquals(expectedX, xCaptor.getValue());
        assertEquals(expectedY, yCaptor.getValue());
        assertEquals(Orientation.valueOf(expectedOrientation), orientationCaptor.getValue());
    }

    @ParameterizedTest
    @MethodSource("generateDataForTestExecuteMovesInputWithValidInputs")
    public void testExecuteMovesInputWithValidInputs(String input, List<Move> moves) {
        ArgumentCaptor<List<Move>> movesCaptor = ArgumentCaptor.forClass(List.class);

        Position position = mock(Position.class);
        when(marsRoverController.getCurrentRover().getPosition()).thenReturn(position);

        presenter.executeMovesInput(input);
        verify(marsRoverController).moveCurrentRover(movesCaptor.capture());
        assertEquals(moves, movesCaptor.getValue());
    }

    private static Stream<Arguments> generateDataForTestExecuteMovesInputWithValidInputs() {
        return Stream.of(
                Arguments.of("M", List.of(Move.M)),
                Arguments.of("MLRMMRL", List.of(Move.M, Move.L, Move.R, Move.M, Move.M, Move.R, Move.L)),
                Arguments.of("LLRR", List.of(Move.L, Move.L, Move.R, Move.R))
        );
    }
}