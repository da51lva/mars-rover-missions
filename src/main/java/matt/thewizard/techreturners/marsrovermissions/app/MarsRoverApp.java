package matt.thewizard.techreturners.marsrovermissions.app;

import matt.thewizard.techreturners.marsrovermissions.model.MarsRoverModel;
import matt.thewizard.techreturners.marsrovermissions.presenter.Presenter;
import matt.thewizard.techreturners.marsrovermissions.view.ConsoleView;

public class MarsRoverApp {

    public static void main(String args[]){
        MarsRoverModel marsRoverModel = new MarsRoverModel();
        ConsoleView consoleView = new ConsoleView(System.console());
        Presenter presenter = new Presenter(marsRoverModel, consoleView);
        presenter.go();
    }
}
