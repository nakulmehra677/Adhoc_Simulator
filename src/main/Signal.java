package main;

import main.models.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class Signal {

    private int sizeX = 1200, sizeY = 600;
    public static Integer[][] signal = new Integer[1200][600];


    public static void changePosition(int id, Coordinates newCoordinates, Coordinates oldCoordinates) {
        if (oldCoordinates != null) {
            signal[oldCoordinates.getX()][oldCoordinates.getY()] = null;
        }
        signal[newCoordinates.getX()][newCoordinates.getY()] = id;
    }
}
