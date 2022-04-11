package com.techreturners.marsroverkata.model;

public class PlateauFactory {

    public static Plateau createNurseryPlateau(int xMax, int yMax){
        return new NurseryPlateau(xMax, yMax);
    }


}
