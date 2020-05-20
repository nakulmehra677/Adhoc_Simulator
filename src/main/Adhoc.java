package main;

public class Adhoc {

    public static void main(String[] args) {

        World world = new World(100, 100);

    }
}

//import java.awt.*;
//import javax.swing.*;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Adhoc extends JFrame {
//
//    public Adhoc() {
//        GameScreen p1 = new GameScreen();
//        add(p1);
//        Timer t = new Timer(100, new ReDraw(p1));
//        t.start();
//    }
//
//    public static void main(String[] args) {
//        Adhoc g = new Adhoc();
//        g.setLocation(80, 40);
//        g.setSize(1200, 600);
//        g.setVisible(true);
//    }
//}
//
//class ReDraw implements ActionListener {
//
//    static int count = 0;
//    static int posX = 603;
//    static int posY = 210;
//    static int velX = 1;
//    static int velY = 1;
//    GameScreen gameScreen;
//
//    ReDraw(GameScreen gameScreen) {
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
//
//class GameScreen extends JPanel {
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