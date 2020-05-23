package main;

import main.models.Coordinates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShortestPath {

    private int src, des, v;
    private List<Integer> visitedNodes;
    private boolean[] visited;
    private double[] distance;

    private List<Integer> path;

    private double[][] graph;


    public ShortestPath(int src, int des) {
        this.src = src;
        this.des = des;

        v = World.hosts.size();
        visited = new boolean[v];
        distance = new double[v];
        path = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;

        graph = new double[v][v];
        for (int i = 0; i < v; i++) {
            List<Host> n = World.hosts.get(i).getNearbyNodes();

            for (int j = 0; j < v; j++) {
                boolean flag = false;
                for (int k = 0; k < n.size(); k++) {
                    if (n.get(k).getId() == j) {
                        Coordinates cord1 = World.hosts.get(i).getCoordinates();
                        Coordinates cord2 = n.get(k).getCoordinates();
                        double dis = Math.sqrt(Math.pow(cord1.getX() - cord2.getX(), 2) + Math.pow(cord1.getY() - cord2.getY(), 2));

                        graph[i][j] = dis;
                    }
                    flag = true;
                }
                if (!flag) {
                    graph[i][j] = 0;
                }
            }
        }
    }

    private int findMinVertex(double[] distance, boolean[] visited) {
        int minVertex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public List<Integer> execute() {

        path.add(src);
        for (int i = 0; i < v - 1; i++) {
            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true;

            for (int j = 0; j < v; j++) {
                if (graph[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE) {
                    double newDist = distance[minVertex] + graph[minVertex][j];

                    if (newDist < distance[j]) {
                        distance[j] = newDist;

                        if (j == des)
                            path.add(minVertex);

                    }
                }
            }
        }

        path.add(des);

        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i));
        }
        System.out.println();

        return path;
    }
}