package main.simulator;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Circles extends JPanel {
    private int x,y,r,s;
    private Color c;
    private Random ran;

    public Circles(int x,int y) {
        // TODO Auto-generated constructor stub
        ran = new Random();
        this.x = x;
        this.y = y;
        r = ran.nextInt(100)+20;
        c = new Color(0,0,0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public Color getC() {
        return c;
    }

    public void setS(int s){
        this.s = s;
    }

    public int getS() {
        return s;
    }

    public void move(int newIndexX) {
        x = newIndexX;
    }
}