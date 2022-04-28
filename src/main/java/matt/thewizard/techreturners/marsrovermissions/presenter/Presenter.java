package matt.thewizard.techreturners.marsrovermissions.presenter;

import matt.thewizard.techreturners.marsrovermissions.model.MarsRoverModel;
import matt.thewizard.techreturners.marsrovermissions.model.Move;
import matt.thewizard.techreturners.marsrovermissions.model.Orientation;
import matt.thewizard.techreturners.marsrovermissions.model.Rover;
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
    public void go(){
        //accept an input for the Plateau size
        String plateauInput = consoleView.displayPlateauInput();
        executePlateauSizeInput(plateauInput);
        consoleView.displayGrid(marsRoverModel.getPlateau().getXMax(),marsRoverModel.getPlateau().getYMax(),marsRoverModel.getRovers());

        String input = "";
        while(true){
            //Add a new rover
            input = consoleView.displayAddNewRover();
            validateInput(input);
            executeNewRoverInput(input);
            consoleView.displayGrid(marsRoverModel.getPlateau().getXMax(),marsRoverModel.getPlateau().getYMax(),marsRoverModel.getRovers());

            //Move rover
            input = consoleView.displayMoveRover();
            validateInput(input);
            executeMovesInput(input);
            consoleView.displayGrid(marsRoverModel.getPlateau().getXMax(),marsRoverModel.getPlateau().getYMax(),marsRoverModel.getRovers());
        }
    }

    public void validateInput(String input){
        switch(input){
            case "q" -> quitApp();
        }
    }

    public void quitApp(){
        consoleView.displayGoodbye();
        System.exit(0);
    }

    public void executePlateauSizeInput(String input) {
        String[] split = input.split(" ");
        int xMAx = Integer.valueOf(split[0]);
        int yMax = Integer.valueOf(split[1]);
        marsRoverModel.createPlateau(xMAx, yMax);
    }

    public void executeNewRoverInput(String input){
        String[] split = input.split(" ");
        int x = Integer.valueOf(split[0]);
        int y = Integer.valueOf(split[1]);
        Orientation orientation = Orientation.valueOf(split[2]);
        marsRoverModel.addRover(x, y, orientation);
    }

    public void executeMovesInput(String input){
          List<Move> moves = Arrays.stream(input.split("")).map(Move::valueOf).collect(Collectors.toList());
          marsRoverModel.moveCurrentRover(moves);
    }

}
