package main;

import main.models.Coordinates;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
    private int sizeX;
    private int sizeY;
    private Random random;

    public World(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        random = new Random();


        List<Host> hosts = createHosts(200);

        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setSize(sizeX, sizeY);
        jFrame.setLocation(60, 30);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panel = new Panel(sizeX, sizeY, hosts);
        jFrame.add(panel);
        panel.setVisible(true);
    }

    public List<Host> createHosts(int totalHosts) {
        List<Host> hosts = new ArrayList<>();

        for (int i = 0; i < totalHosts; i++) {
            int xCoord = random.nextInt(sizeX - 100);
            int yCoord = random.nextInt(sizeY - 100);

            int movementX = random.nextBoolean() ? 1 : -1;
            int movementY = random.nextBoolean() ? 1 : -1;

            Host host = new Host(i, new Coordinates(xCoord, yCoord), 50, movementX, movementY);
            hosts.add(host);
        }

        return hosts;
    }
}