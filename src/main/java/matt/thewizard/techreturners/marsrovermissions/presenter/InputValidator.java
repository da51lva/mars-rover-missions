package matt.thewizard.techreturners.marsrovermissions.presenter;

import matt.thewizard.techreturners.marsrovermissions.model.Orientation;

import java.util.Arrays;

import static matt.thewizard.techreturners.marsrovermissions.presenter.InputConstants.*;

/**
 * Validates user inputs
 */
public class InputValidator {

    /**
     * Returns whether an input to Create a Plateau is valid
     */
    public static boolean isValidCreatePlateauInput(String input) {

        String[] split = input.split(SEPARATOR);

        if (input.equals(QUIT_CHAR)) return true; //'q' is valid

        if (split.length != 2) return false; //should be two values

        try {
            Arrays.stream(split)
                    .forEach(Integer::parseInt); //should be integers
        } catch (NumberFormatException e) {
            return false;
        }

        return true;

    }

    /**
     * Returns whether and input to select an option is valid
     */
    public static boolean isValidOptionsInput(String input) {
        if (!input.equals(OPTION_1) && !input.equals(OPTION_2) && !input.equals(QUIT_CHAR)) return false; //should be '1', '2' or 'q'
        else return true;
    }

    public static boolean isValidRoverCreationInput(String input) {

        String[] split = input.split(SEPARATOR);

        if (input.equals(QUIT_CHAR)) return true; //'q' is valid

        if (split.length != 3) return false; //should be 3 values

        try {
            Integer.parseInt(split[0]); //should be an integer
            Integer.parseInt(split[1]); //should be an integer
            Orientation.valueOf(split[2]); //Should be string value of enum Orientation
        } catch (NumberFormatException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

}
