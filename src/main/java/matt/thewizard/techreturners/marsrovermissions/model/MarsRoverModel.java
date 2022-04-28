package matt.thewizard.techreturners.marsrovermissions.model;

import java.util.List;

public class MarsRoverModel {

    private Plateau plateau;


    public void createPlateau(int xMax, int yMax){
        this.plateau = new NurseryPlateau(xMax, yMax);
    }

    public void addRover(int x, int y, Orientation orientation) {
        plateau.createNewRover(x, y, orientation);
    }

    public Rover getRover(int roverId) {
        return plateau.getRover(roverId);
    }

    public List<Rover> getRovers(){
        return plateau.getRovers();
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void moveRover(int id, List<Move> moves) {
        Rover rover = plateau.getRover(id);
        moves.stream()
                .forEach((move) -> moveRover(rover,move));
    }

    private void moveRover(Rover rover, Move move) {
        switch (move) {
            case M:
                plateau.moveRover(rover);
                break;
            case R:
                rover.orientateRight();
                break;
            case L:
                rover.orientateLeft();
                break;
        }
    }
}
