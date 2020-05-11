package main;

import java.util.List;

public class Network {

    private List<Node> nodeList;
    private List<Edge> edgeList;

    public Network() {

    }

    public void addNode(Node node) {
        nodeList.add(node);
    }

    public void addEdge(Edge edge) {
        edgeList.add(edge);
    }

    public Node getNode(int id) {
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).getId() == id) {
                return nodeList.get(i);
            }
        }
        return null;
    }
}
