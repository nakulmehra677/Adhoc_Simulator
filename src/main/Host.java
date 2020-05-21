package main;

import main.models.Coordinates;

import java.util.List;

public class Host {

    private int id;
    private Coordinates coordinates;
    private int range;
    private int worldXRange = 10;
    private int worldYRange = 10;
    private int movementX, movementY;

    private List<Edge> nearbyNodes;
    private List<String> friendNodes;


    public Host(int id, Coordinates coordinates, int range, int movementX, int movementY) {
        setId(id);
        setRange(range);
        setCoordinates(coordinates);

        this.movementX = movementX;
        this.movementY = movementY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        Signal.changePosition(id, coordinates, this.coordinates);
        this.coordinates = coordinates;

    }

    public int getMovementX() {
        return movementX;
    }

    public int getMovementY() {
        return movementY;
    }

    public void setMovementX(int movementX) {
        this.movementX = movementX;
    }

    public void setMovementY(int movementY) {
        this.movementY = movementY;
    }
}
