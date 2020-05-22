package main.interfaces;

import main.models.Coordinates;

public interface NodeListener {

    void locationChanged(int id, Coordinates oldCoordinates, Coordinates newCoordinates);

    void checkNearByNodes(int id, Coordinates coordinates, int range);
}
