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
    Timer t = new Timer(60, this);
    private Random random;
    private List<Integer> path;

    public Panel(int frameSizeX, int frameSizeY, List<Host> hosts) {
        this.frameSizeX = frameSizeX;
        this.frameSizeY = frameSizeY;

        path = new ArrayList<>();
        path.add(0);
        path.add(1);
        path.add(2);
        path.add(3);
        path.add(4);
        path.add(5);
        path.add(6);
        path.add(7);
        path.add(8);
        path.add(9);
        path.add(10);
        path.add(11);
        path.add(12);
        path.add(13);
        path.add(14);

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < World.hosts.size(); i++) {

            int x = World.hosts.get(i).getCoordinates().getX();
            int y = World.hosts.get(i).getCoordinates().getY();

            if (World.firstNode == i || World.secondNode == i) {
                g.setColor(Color.blue);
            } else {
                g.setColor(Color.green);
            }

            Graphics2D g2 = (Graphics2D) g;
            Ellipse2D circle = new Ellipse2D.Double(
                    x - circleRadius / 2, y - circleRadius / 2, circleRadius, circleRadius);

            g2.fill(circle);

            for (int p = 0; p < World.hosts.get(i).getNearbyNodes().size(); p++) {
                Host h = World.hosts.get(i).getNearbyNodes().get(p);
                int coordinatesX = h.getCoordinates().getX();
                int coordinatesY = h.getCoordinates().getY();

                g.setColor(Color.lightGray);
                if (World.firstNode != -1 && World.secondNode != -1) {
                    if (path.get(0) == i || h.getId() == path.get(0)) {
                        System.out.println(i + "->" + p);
                        g.setColor(Color.black);
                    }
                }
                g.drawLine(x, y, coordinatesX, coordinatesY);

            }

            g.setColor(Color.black);
            g.drawString(String.valueOf(World.hosts.get(i).getId()), x, y);

        }


        t.start();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        for (int i = 0; i < World.hosts.size(); i++) {
            if (World.hosts.get(i).getCoordinates().getX() <= 0 ||
                    World.hosts.get(i).getCoordinates().getX() > frameSizeX - circleRadius) {
                World.hosts.get(i).setMovementX(-World.hosts.get(i).getMovementX());
            }

            if (World.hosts.get(i).getCoordinates().getY() <= 0 ||
                    World.hosts.get(i).getCoordinates().getY() > frameSizeY - circleRadius) {
                World.hosts.get(i).setMovementY(-World.hosts.get(i).getMovementY());
            }

            Coordinates coordinates = new Coordinates(
                    World.hosts.get(i).getCoordinates().getX() + World.hosts.get(i).getMovementX(),
                    World.hosts.get(i).getCoordinates().getY() + World.hosts.get(i).getMovementY());

            World.hosts.get(i).setCoordinates(coordinates);
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
