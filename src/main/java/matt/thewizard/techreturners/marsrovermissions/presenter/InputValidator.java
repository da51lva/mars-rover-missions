package matt.thewizard.techreturners.marsrovermissions.presenter;

import java.util.Arrays;

import static matt.thewizard.techreturners.marsrovermissions.presenter.InputConstants.QUIT_CHAR;
import static matt.thewizard.techreturners.marsrovermissions.presenter.InputConstants.SEPARATOR;

public class InputValidator {


    /**
     * Returns whether an input to Create a Plateau is valid
     */
    public static boolean isValidCreatePlateauInput(String input){

        String[] split = input.split(SEPARATOR);

        if(input.equals(QUIT_CHAR)) return true;

        if(split.length != 2) return false;

        try {
            Arrays.stream(split).forEach(Integer::parseInt);
        } catch (NumberFormatException e){
            return false;
        }

        return true;

    }

}
