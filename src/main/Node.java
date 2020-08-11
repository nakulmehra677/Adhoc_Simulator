package main;

import main.interfaces.NodeListener;
import main.models.Coordinates;

import java.util.*;

public class Node {

    private int id;                     // unique identity of node
    private Coordinates coordinates;    // position of node in x-y coordinate
    private int range;                  // the distance within which a nodes can communicate to another nodes
    private int worldXRange;            // max horizontal range of world
    private int worldYRange;            // max vertical range of world
    private int movementX, movementY;   // movement direction
    private NodeListener listener;

    private List<Node> nearbyNodes;

    public Node(int id, Coordinates coordinates, int range, int movementX, int movementY,
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

    public List<Node> getNearbyNodes() {
        return nearbyNodes;
    }

    public void setNearbyNodes(List<Node> nearbyNodes) {
        this.nearbyNodes = nearbyNodes;
    }

    private void checkNearByNodes() {

        List<Node> nodes = new ArrayList<>();

        for (int i = coordinates.getX() - range; i <= coordinates.getX() + range; i++) {
            for (int j = coordinates.getY() - range; j <= coordinates.getY() + range; j++) {

                if (i >= 0 && i < worldXRange && j >= 0 && j < worldYRange) {
                    if (Signal.signal[i][j] != null &&
                            coordinates.getX() != i &&
                            coordinates.getY() != j) {
                        nodes.add(World.nodes.get(Signal.signal[i][j]));
                    }
                }
            }
        }

        setNearbyNodes(nodes);
    }
}