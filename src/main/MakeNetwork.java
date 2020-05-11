package main;

import main.models.Coordinates;

import java.util.List;

public class MakeNetwork {
    private Network network;

    public MakeNetwork() {
        network = new Network();

        for (int i = 0; i < 10; i++) {
            network.addNode(new Node(i, new Coordinates(i, i % 2)));
        }

        for (int i = 0; i < 10; i++) {
            Node node = network.getNode(i);

        }

    }
}
