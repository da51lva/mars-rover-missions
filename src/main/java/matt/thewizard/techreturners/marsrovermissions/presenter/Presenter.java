package matt.thewizard.techreturners.marsrovermissions.presenter;

import matt.thewizard.techreturners.marsrovermissions.model.MarsRoverModel;
import matt.thewizard.techreturners.marsrovermissions.model.Move;
import matt.thewizard.techreturners.marsrovermissions.model.Orientation;
import matt.thewizard.techreturners.marsrovermissions.view.ConsoleView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Presenter {

    private MarsRoverModel marsRoverModel;
    private ConsoleView consoleView;

    public Presenter(MarsRoverModel marsRoverModel, ConsoleView consoleView) {
        this.marsRoverModel = marsRoverModel;
        this.consoleView = consoleView;
    }

    /**
     * Controls the flow of the application.
     */
    public void go() {

        consoleView.displayWelcome();

        //accept an input for the Plateau size
        String input = consoleView.displayPlateauInput();
        validateInput(input);
        executePlateauSizeInput(input);
        consoleView.displayGrid(marsRoverModel.getPlateau().getXMax(),
                                marsRoverModel.getPlateau().getYMax(),
                                marsRoverModel.getRovers());


        while (true) {

            input = consoleView.displayChooseOption();
            validateInput(input);
            int option = Integer.parseInt(input);
            if (option == 1) {
                addNewRover();
            } else if (option == 2) {
                moveExistingRover();
            }

        }
    }

    private void moveExistingRover() {

        String input = consoleView.displayChooseRover();
        validateInput(input);
        int roverId = Integer.parseInt(input);
        //TODO: Display grid with highlight

        //Move rover
        input = consoleView.displayMoveRover();
        validateInput(input);
        executeMovesInput(roverId,input);
        consoleView.displayGrid(marsRoverModel.getPlateau().getXMax(),
                                marsRoverModel.getPlateau().getYMax(),
                                marsRoverModel.getRovers());
    }

    private void addNewRover() {
        String input = consoleView.displayAddNewRover();
        validateInput(input);
        executeNewRoverInput(input);
        consoleView.displayGrid(marsRoverModel.getPlateau().getXMax(),
                                marsRoverModel.getPlateau().getYMax(),
                                marsRoverModel.getRovers());
    }


    private void validateInput(String input) {
        switch (input) {
            case "q" -> quitApp();
        }
    }

    private void quitApp() {
        consoleView.displayGoodbye();
        System.exit(0);
    }

    private void executePlateauSizeInput(String input) {
        String[] split = input.split(" ");
        int xMAx = Integer.parseInt(split[0]);
        int yMax = Integer.parseInt(split[1]);
        marsRoverModel.createPlateau(xMAx, yMax);
    }

    private void executeNewRoverInput(String input) {
        String[] split = input.split(" ");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        Orientation orientation = Orientation.valueOf(split[2]);
        marsRoverModel.addRover(x, y, orientation);
    }


    private void executeMovesInput(int roverId, String input) {
        List<Move> moves = Arrays.stream(input.split(""))
                .map(Move::valueOf)
                .collect(Collectors.toList());
        marsRoverModel.moveRover(roverId,moves);
    }

}
