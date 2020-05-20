package main;

import main.models.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class SignalsInWorld {

    private int sizeX = 10, sizeY = 10;
    public static Integer[][] signal = new Integer[10][10];


    public static void setUpNodeSignal(int id, Coordinates newCoordinates, Coordinates oldCoordinates, int range) {
        if (oldCoordinates != null) {
            signal[oldCoordinates.getX()][oldCoordinates.getY()] = null;
        }
        signal[newCoordinates.getX()][newCoordinates.getY()] = id;
    }
}
