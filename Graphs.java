import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.util.*;
import javax.swing.event.*;
import java.awt.event.*;
import static java.lang.Math.sqrt;

public class Graphs {
    public JFrame frame;

    public Graphs(){
        Height graph1 = new Height();

        frame = new JFrame();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Velocity");
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.add(graph1);

        frame.setLocation(800,200);
    }

    public void showFrame(){
        frame.setVisible(Main.ViewGraphs);

    }
}

class Height extends JPanel {
    public static final int W = 500;
    public static final int H = 500;

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int graphx = 50;
        int graphy = 425;

        double gravity = 9.81, h1 = 100;
        double vA, vB, vC, vD, h2, h3, h4;

        //Final Velocity vs Height

        g2.drawLine(50,425,450,425);
        g2.drawLine(50,425,50,25);
        for (int i=0;i<16;i++)
        {
            graphx = graphx+25;
            g2.drawLine(graphx,420,graphx,430);
            graphy = graphy-25;
            g2.drawLine(45,graphy,55,graphy);
        }

        g2.drawString("Initial Height (m)",195,460);
        g2.drawString("Final Velocity (m/s)",10,20);
        g2.drawString("Final Velocity vs.",200,10);
        g2.drawString("Initial Height",215,30);
        g2.drawString("0",30,445);
        graphx = 50;
        graphy = 425;

        for (int i=0;i<400;i++)
        {
            graphx = graphx + 1;
            h1 = h1 + 0.1;

            vA = sqrt(2*gravity*h1);

            h2 = 0.4*h1;
            vB = sqrt((.5*(vA*vA)-(gravity*h2))/.5);

            h3 = 1.3*h1;
            vC = sqrt((.5*(vB*vB)+(gravity*h3))/.5);

            h4 = 0.2*h1;
            vD =sqrt((.5*(vC*vC)-(gravity*h4))/.5);
            vD = vD+400-(2*(vD-25)) - 200;
            graphy = (int) vD+50;
            g2.drawOval(graphx,graphy,1,1);
        }
    }
}
