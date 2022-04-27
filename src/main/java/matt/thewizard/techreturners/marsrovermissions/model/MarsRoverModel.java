package matt.thewizard.techreturners.marsrovermissions.model;

import java.util.List;

public class MarsRoverModel {

    private Plateau plateau;

    private Rover currentRover;


    public void createPlateau(int xMax, int yMax){
        this.plateau = new NurseryPlateau(xMax, yMax);
    }

    public void addRover(int x, int y, Orientation orientation) {
        currentRover = plateau.createNewRover(x, y, orientation);
    }

    public Rover getCurrentRover() {
        return currentRover;
    }

    public List<Rover> getRovers(){
        return plateau.getRovers();
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void moveCurrentRover(List<Move> moves) {
        moves.stream()
                .forEach(this::moveCurrentRover);
    }

    private void moveCurrentRover(Move move) {
        switch (move) {
            case M:
                plateau.moveRover(currentRover);
                break;
            case R:
                currentRover.orientateRight();
                break;
            case L:
                currentRover.orientateLeft();
                break;
        }
    }
}
