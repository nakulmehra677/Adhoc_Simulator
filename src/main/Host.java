package main;

import main.interfaces.NodeListener;
import main.models.Coordinates;

import java.util.*;

public class Host {

    private int id;
    private Coordinates coordinates;
    private int range;
    private int worldXRange;
    private int worldYRange;
    private int movementX, movementY;
    private NodeListener listener;

    private List<Host> nearbyNodes;

    public Host(int id, Coordinates coordinates, int range, int movementX, int movementY,
                int worldXRange, int worldYRange, NodeListener listener) {
        this.listener = listener;
        nearbyNodes = new LinkedList<>();

        setId(id);
        setRange(range);
        setCoordinates(coordinates);

        this.worldXRange = worldXRange;
        this.worldYRange = worldYRange;
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
        listener.locationChanged(id, this.coordinates, coordinates);
        this.coordinates = coordinates;
        checkNearByNodes();
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

    public List<Host> getNearbyNodes() {
        return nearbyNodes;
    }

    public void setNearbyNodes(List<Host> nearbyNodes) {
        this.nearbyNodes = nearbyNodes;
    }

    private void checkNearByNodes() {

        List<Host> nodes = new ArrayList<>();

        for (int i = coordinates.getX() - range; i <= coordinates.getX() + range; i++) {
            for (int j = coordinates.getY() - range; j <= coordinates.getY() + range; j++) {

                if (i >= 0 && i < worldXRange && j >= 0 && j < worldYRange) {
                    if (Signal.signal[i][j] != null &&
                            coordinates.getX() != i &&
                            coordinates.getY() != j) {
                        nodes.add(World.hosts.get(Signal.signal[i][j]));
                    }
                }
            }
        }

        setNearbyNodes(nodes);
    }
}