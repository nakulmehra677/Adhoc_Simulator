package main.simulator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class CreateFrame extends JFrame implements Runnable {

    private static Circles myCircle;
    private static int numberOfCircle;
    private Random ran;
    private static final ArrayList<Circles> circleList = new ArrayList<>();


    public CreateFrame(int numberOfCircl) {
        numberOfCircle = numberOfCircl;
        setVisible(true);
        setSize(700, 700);
        setTitle("Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread t = new Thread(this);
        t.start();
        System.out.println(t.getName());
    }

    public void creatingCircles(int x, int y) {
        myCircle = new Circles(x, y);
        myCircle.setS((x+y) /2);
        circleList.add(myCircle);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (circleList.size() > 0)
            for (Circles myCircle : circleList) {
                g.setColor(myCircle.getC());
                g.fillOval(myCircle.getX(), myCircle.getY(), 20, 20);
            }
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                if (circleList.size() > 0)
                    for (Circles myCircle : circleList) {
                        myCircle.move(myCircle.getS());
                    }
                repaint();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }

    }
}

