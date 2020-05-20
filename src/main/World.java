package main;

import javafx.scene.shape.Circle;
import main.models.Coordinates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


        List<Host> hosts = createHosts(10);

//        Play g = new Play();
//        g.setLocation(80, 40);
//        g.setSize(1200, 600);
//        g.setVisible(true);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < hosts.size(); j++) {
                int xCordNew = random.nextInt(3) - 1 + hosts.get(j).getCoordinates().getX();
                int yCordNew = random.nextInt(3) - 1 + hosts.get(j).getCoordinates().getY();

                if (xCordNew > 0 && xCordNew < sizeX && yCordNew > 0 && yCordNew < sizeY) {
                    hosts.get(j).setCoordinates(new Coordinates(xCordNew, yCordNew));
                }

                System.out.println(hosts.get(j).getId() + "->" +
                        hosts.get(j).getCoordinates().getX() + " " + hosts.get(j).getCoordinates().getY());
            }
            System.out.println();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public List<Host> createHosts(int totalHosts) {
        List<Host> hosts = new ArrayList<>();

        for (int i = 0; i < totalHosts; i++) {
            int xCoord = random.nextInt(sizeX);
            int yCoord = random.nextInt(sizeY);

            Host host = new Host(i, new Coordinates(xCoord, yCoord), 2);
            hosts.add(host);
        }

        return hosts;
    }
}

//class Play extends JFrame {
//
//    public Play() {
//        Screen p1 = new Screen();
//        add(p1);
//        Timer t = new Timer(100, new ReDrw(p1));
//        t.start();
//    }
//}

//class ReDrw implements ActionListener {
//
//    static int count = 0;
//    static int posX = 603;
//    static int posY = 210;
//    static int velX = 1;
//    static int velY = 1;
//    Screen gameScreen;
//
//    ReDrw(Screen gameScreen) {
//        this.gameScreen = gameScreen;
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("actionPerformed");
//        count++;
//
//        posX -= velX;
//        posY -= velY;
//        System.out.println("Flag 1: " + posX + " " + posY);
//        gameScreen.repaint();
//
//        if (count == 40) {
//            ((Timer) e.getSource()).stop();
//        }
//    }
//}


//class Screen extends JPanel {
//
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        System.out.println("paintComponent called");
//
//        g.setColor(Color.red);
//        g.fillOval(ReDraw.posX, ReDraw.posY, 50, 50);
//    }
//}