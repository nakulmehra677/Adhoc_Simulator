package main;

import main.models.Coordinates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {

    private double frameSizeX, frameSizeY;
    private int circleRadius = 40;
    Timer t = new Timer(50, this);
    private Random random;
    private List<Integer> path;

    public Panel(int frameSizeX, int frameSizeY, List<Node> nodes) {
        this.frameSizeX = frameSizeX;
        this.frameSizeY = frameSizeY;

        path = new ArrayList<>();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < World.nodes.size(); i++) {

            int x = World.nodes.get(i).getCoordinates().getX();
            int y = World.nodes.get(i).getCoordinates().getY();

            if (World.firstNode == i || World.secondNode == i) {
                g.setColor(Color.blue);
            } else {
                g.setColor(Color.green);
            }

            Graphics2D g2 = (Graphics2D) g;
            Ellipse2D circle = new Ellipse2D.Double(
                    x - circleRadius / 2, y - circleRadius / 2, circleRadius, circleRadius);

            g2.fill(circle);

            for (int p = 0; p < World.nodes.get(i).getNearbyNodes().size(); p++) {
                Node h = World.nodes.get(i).getNearbyNodes().get(p);
                int coordinatesX = h.getCoordinates().getX();
                int coordinatesY = h.getCoordinates().getY();

                g2.setColor(Color.lightGray);
                g2.setStroke(new BasicStroke(1));
//                if (World.firstNode != -1 && World.secondNode != -1) {
//                    for (int q = 1; q < path.size() - 1; q++) {
//                        if ((i == path.get(q) && h.getId() == path.get(q + 1)) ||
//                                (i == path.get(q) && h.getId() == path.get(q - 1))) {
//                            g2.setColor(Color.black);
//                            g2.setStroke(new BasicStroke(2));
//                        }
//                    }
//                }
                g2.drawLine(x, y, coordinatesX, coordinatesY);

            }

            g2.setColor(Color.black);
            g2.drawString(String.valueOf(World.nodes.get(i).getId()), x, y);

        }

        if (World.firstNode != -1 && World.secondNode != -1) {
            ShortestPath s = new ShortestPath(World.firstNode, World.secondNode);
            System.out.println(s.execute() + " units");
        }
        t.start();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        for (int i = 0; i < World.nodes.size(); i++) {
            if (World.nodes.get(i).getCoordinates().getX() <= 0 ||
                    World.nodes.get(i).getCoordinates().getX() > frameSizeX - circleRadius) {
                World.nodes.get(i).setMovementX(-World.nodes.get(i).getMovementX());
            }

            if (World.nodes.get(i).getCoordinates().getY() <= 0 ||
                    World.nodes.get(i).getCoordinates().getY() > frameSizeY - circleRadius) {
                World.nodes.get(i).setMovementY(-World.nodes.get(i).getMovementY());
            }

            Coordinates coordinates = new Coordinates(
                    World.nodes.get(i).getCoordinates().getX() + World.nodes.get(i).getMovementX(),
                    World.nodes.get(i).getCoordinates().getY() + World.nodes.get(i).getMovementY());

            World.nodes.get(i).setCoordinates(coordinates);
        }

        repaint();
    }

    public void pause() {
        t.stop();
    }

    public void play() {
        t.start();
    }
}
