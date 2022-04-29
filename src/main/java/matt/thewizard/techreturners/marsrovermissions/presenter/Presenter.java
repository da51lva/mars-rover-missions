package matt.thewizard.techreturners.marsrovermissions.presenter;

import matt.thewizard.techreturners.marsrovermissions.model.MarsRoverModel;
import matt.thewizard.techreturners.marsrovermissions.model.Move;
import matt.thewizard.techreturners.marsrovermissions.model.Orientation;
import matt.thewizard.techreturners.marsrovermissions.view.ConsoleView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static matt.thewizard.techreturners.marsrovermissions.presenter.InputConstants.QUIT_CHAR;
import static matt.thewizard.techreturners.marsrovermissions.presenter.InputValidator.isValidCreatePlateauInput;
import static matt.thewizard.techreturners.marsrovermissions.presenter.InputValidator.isValidOptionsInput;

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
        presentCreatePlateau();

        presentRoverOptions();
    }
    
    private void presentCreatePlateau() {

        String input = consoleView.displayPlateauInput();
        boolean isValidInput = isValidCreatePlateauInput(input);

        while (isValidInput == false) {
            ConsoleView.displayInputErrorMessage(input);
            input = consoleView.displayPlateauInput();
            isValidInput = isValidCreatePlateauInput(input);
        }

        checkQuit(input);
        executePlateauSizeInput(input);

        consoleView.displayGrid(
                marsRoverModel.getPlateau().getXMax(),
                marsRoverModel.getPlateau().getYMax(),
                marsRoverModel.getRovers()
        );

    }

    private void presentRoverOptions(){
        while(true){

            String input = consoleView.displayChooseOption();
            boolean isValidInput = isValidOptionsInput(input);

            while(isValidInput == false){
                ConsoleView.displayInputErrorMessage(input);
                input = consoleView.displayChooseOption();
                isValidInput = isValidOptionsInput(input);
            }

            checkQuit(input);
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
        checkQuit(input);
        int roverId = Integer.parseInt(input);
        //TODO: Display grid with highlight

        //Move rover
        input = consoleView.displayMoveRover();
        checkQuit(input);
        executeMovesInput(roverId, input);
        consoleView.displayGrid(
                marsRoverModel.getPlateau().getXMax(),
                marsRoverModel.getPlateau().getYMax(),
                marsRoverModel.getRovers()
        );
    }

    private void addNewRover() {
        String input = consoleView.displayAddNewRover();
        checkQuit(input);
        executeNewRoverInput(input);
        consoleView.displayGrid(
                marsRoverModel.getPlateau().getXMax(),
                marsRoverModel.getPlateau().getYMax(),
                marsRoverModel.getRovers()
        );
    }


    private void checkQuit(String input) {
        if (input.equals(QUIT_CHAR)) quitApp();
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
        marsRoverModel.moveRover(roverId, moves);
    }

}
