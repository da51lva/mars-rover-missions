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
          Rover rover = marsRoverModel.getCurrentRover();
          consoleView.displayResult(rover.getPosition().getX(),
                                    rover.getPosition().getY(),
                                    rover.getOrientation());
          consoleView.displayGrid(marsRoverModel.getPlateau().getXMax(),marsRoverModel.getPlateau().getYMax(),marsRoverModel.getRovers());
    }

}