package com.techreturners.marsroverkata.app;

import com.techreturners.marsroverkata.model.MarsRoverModel;
import com.techreturners.marsroverkata.presenter.Presenter;
import com.techreturners.marsroverkata.view.ConsoleView;

public class MarsRoverApp {

    public static void main(String args[]){
        MarsRoverModel marsRoverModel = new MarsRoverModel();
        ConsoleView consoleView = new ConsoleView();
        Presenter presenter = new Presenter(marsRoverModel, consoleView);
        consoleView.setPresenter(presenter);
        consoleView.welcome();
    }
}
