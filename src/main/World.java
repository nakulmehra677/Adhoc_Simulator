package main;

import main.interfaces.NodeListener;
import main.models.Coordinates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World implements NodeListener {
    private int sizeX;
    private int sizeY;
    private Random random;
    public static List<Host> hosts;
    private JFrame jFrame;
    private Panel panel;
    private JMenuBar jMenuBar;

    public static int firstNode = -1, secondNode = -1;


    public World(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        random = new Random();


        hosts = createHosts(20);

        Thread thread = new Thread(() -> {
            System.out.println("Thread Running");

            jFrame = new JFrame("Adhoc Simulator");
            jMenuBar = new JMenuBar();

            jFrame.setVisible(true);
            jFrame.setSize(sizeX, sizeY);
            jFrame.setLocation(60, 30);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panel = new Panel(sizeX, sizeY, hosts);
            panel.setBackground(Color.white);
            panel.setVisible(true);

            addButtons();
            addMenus();

            jFrame.setJMenuBar(jMenuBar);
            jFrame.add(panel);

        });

        thread.start();
    }


    private void addButtons() {
        JButton play = new JButton("Play");
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.play();
            }
        });
        jMenuBar.add(play);

        JButton pause = new JButton("Pause");
        pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.pause();
            }
        });
        jMenuBar.add(pause);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                tf.setText("Welcome to Javatpoint.");
            }
        });
        jMenuBar.add(stop);
    }


    private void addMenus() {
        JMenu firstNodeMenu = new JMenu("First Node");

        for (int i = 0; i < hosts.size(); i++) {
            JMenuItem jMenuItem = new JMenuItem(String.valueOf(hosts.get(i).getId()));
            int finalI = i;
            jMenuItem.addActionListener(e -> firstNode = hosts.get(finalI).getId());
            firstNodeMenu.add(jMenuItem);
        }

        jMenuBar.add(firstNodeMenu);


        JMenu secondNodeMenu = new JMenu("Second Node");

        for (int i = 0; i < hosts.size(); i++) {
            JMenuItem jMenuItem = new JMenuItem(String.valueOf(hosts.get(i).getId()));
            int finalI = i;
            jMenuItem.addActionListener(e -> secondNode = hosts.get(finalI).getId());
            secondNodeMenu.add(jMenuItem);
        }

        jMenuBar.add(secondNodeMenu);
    }


    public List<Host> createHosts(int totalHosts) {
        hosts = new ArrayList<>();

        for (int i = 0; i < totalHosts; i++) {
            int xCoord = random.nextInt(sizeX - 100);
            int yCoord = random.nextInt(sizeY - 100);

            int movementX = random.nextBoolean() ? 1 : -1;
            int movementY = random.nextBoolean() ? 1 : -1;

            Host host = new Host(i, new Coordinates(xCoord, yCoord),
                    300, movementX, movementY, sizeX, sizeY, this);
            hosts.add(host);
        }

        return hosts;
    }

    @Override
    public void locationChanged(int id, Coordinates oldCoordinates, Coordinates newCoordinates) {
        Signal.changePosition(id, newCoordinates, oldCoordinates);
    }

    @Override
    public void checkNearByNodes(int id, Coordinates coordinates, int range) {

    }
}