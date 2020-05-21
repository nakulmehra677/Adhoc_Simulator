package main;

import main.models.Coordinates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.List;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {

    private double frameSizeX, frameSizeY;
    private int circleRadius = 10;
    private List<Host> hosts;
    Timer t = new Timer(60, this);
    private Random random;
    private int range = 80;

    public Panel(int frameSizeX, int frameSizeY, List<Host> hosts) {
        this.frameSizeX = frameSizeX;
        this.frameSizeY = frameSizeY;

        this.hosts = hosts;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < hosts.size(); i++) {

            int x = hosts.get(i).getCoordinates().getX();
            int y = hosts.get(i).getCoordinates().getY();

            g.setColor(Color.red);
            Graphics2D g2 = (Graphics2D) g;
            Ellipse2D circle = new Ellipse2D.Double(x, y, circleRadius, circleRadius);

            g2.fill(circle);

            for (int p = x - range; p < x + range + 1; p++) {
                for (int q = y - range; q < y + range + 1; q++) {
                    if (p >= 0 && p < frameSizeX && q >= 0 && q < frameSizeY) {
                        if (Signal.signal[p][q] != null) {
                            g.setColor(Color.black);
                            g.drawLine(x + circleRadius / 2, y + circleRadius / 2,
                                    p + circleRadius / 2, q + circleRadius / 2);
                        }
                    }
                }
            }
        }

        t.start();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        for (int i = 0; i < hosts.size(); i++) {
            if (hosts.get(i).getCoordinates().getX() <= 0 ||
                    hosts.get(i).getCoordinates().getX() > frameSizeX - circleRadius) {
                hosts.get(i).setMovementX(-hosts.get(i).getMovementX());
            }

            if (hosts.get(i).getCoordinates().getY() <= 0 ||
                    hosts.get(i).getCoordinates().getY() > frameSizeY - circleRadius) {
                hosts.get(i).setMovementY(-hosts.get(i).getMovementY());
            }

            Coordinates coordinates = new Coordinates(
                    hosts.get(i).getCoordinates().getX() + hosts.get(i).getMovementX(),
                    hosts.get(i).getCoordinates().getY() + hosts.get(i).getMovementY());

            hosts.get(i).setCoordinates(coordinates);
        }

        repaint();
    }
}
