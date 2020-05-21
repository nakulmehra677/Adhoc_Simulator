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


//        for (int i = 0; i < signal.length; i++) {
//            for (int j = 0; j < signal[0].length; j++) {
//                System.out.print(signal[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
    }
}
