package main;

import main.models.Coordinates;

import java.util.List;

public class Node {
    private int id;
    private Coordinates coordinates;
    private List<Edge> nearbyNodes;

    public Node(int id, Coordinates coordinates) {
        this.id = id;
        this.coordinates = coordinates;
    }

    public int getId() {
        return id;
    }
}
