package main;

import main.models.Coordinates;

import java.util.List;

public class Host {

    private int id;
    private Coordinates coordinates;
    private int range;
    private int worldXRange = 10;
    private int worldYRange = 10;

    private List<Edge> nearbyNodes;
    private List<String> friendNodes;


    public Host(int id, Coordinates coordinates, int range) {
        setId(id);
        setRange(range);
        setCoordinates(coordinates);
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
        this.coordinates = coordinates;
    }
}
