package main.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class CircularAnimation extends JPanel{

    private int x, y;
    private int velx;
    private Timer t;

    public CircularAnimation(int x, int y) {
        t = new Timer(1000,new MotionListener());
        velx = 25;
        this.x = x;
        this.y = y;
        System.out.println("CircularAnimation");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x,y,100,100);
        g2.setColor(Color.magenta);
        g2.draw(circle);
        t.start();
    }

    private  class MotionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //x = x + velx;
           // repaint();
            repaint();

        }
    }
}
